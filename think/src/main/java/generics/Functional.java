package generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static net.mindview.util.Print.print;

// Different types of function objects:
interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result(); // Extract result of collecting parameter
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

public class Functional {
    // Calls the Combiner object on each element to combine
    // it with a running result, which is finally returned:
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext()) {
                result = combiner.combine(result, it.next());
            }
            return result;
        }
        // If seq is the empty list:
        return null; // Or throw exception
    }

    // Take a function object and call it on each object in
    // the list, ignoring the return value. The function
    // object may act as a collecting parameter, so it is
    // returned at the end.
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq)
            func.function(t);
        return func;
    }

    // Creates a list of results by calling a
    // function object for each object in the list:
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq)
            result.add(func.function(t));
        return result;
    }

    // Applies a unary predicate to each item in a sequence,
    // and returns a list of items that produced "true":
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq)
            if (pred.test(t))
                result.add(t);
        return result;
    }

    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {
        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {
        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;

        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }

    /**
     * <p>
     * 如果只查看尝试添加对象的过程，就会看到这是在多个类中的公共操作，但
     * 是这个操作没有在任何我们可以指定的基类中表示一有时甚至可以使用"+"操作符，
     * 而其他时间可以使用某种add方法。
     * <p>
     * 这是在试图编写泛化代码的时候通常会碰到的情况，因为你想将这些代码应用于多个类上
     * 特别是，像本例一样，作用于多个已经存在且我们不能"修正"的类上。
     * <p>
     * 即使你可以将这种情况窄化到Number的子类，这个超类也不包括任何有关"可添加性"的东西。
     * 解决方案是使用策略设计模式，这种设计模式可以产生更优雅的代码，
     * 因为它将"变化的事物"完全隔离到了一个函数对象中。
     * <p>
     * 函数对象就是在某种程度上行为像函数的对象,一般地，会有一个相关的方法
     * （在支持操作符重载的语言中，可以创建对这个方法的调用，而这个调用看起来就和普通的方法调用一样）。
     * <p>
     * 函数对象的价值就在于，与普通方法不同，它们可以传递出去，并且还可
     * 以拥有在多个调用之间持久化的状态。
     * <p>
     * 当然，可以用类中的任何方法来实现与此相似的操作，
     * 但是（与使用任何设计模式一样）函数对象主要是由其目的来区别的。
     * <p>
     * 这里的目的就是要创建某种事物，使它的行为就像是一个可以传递出去的单
     * 个方法一样，这样，它就和策略设计模式紧耦合了，有时甚至无法区分。
     * <p>
     * 尽管可以发现我使用了大量的设计模式，但是在这里它们之间的界限是模糊
     * 的:我们在创建执行适配操作的函数对象，而它们将被传递到用作策略的方法中。
     */
    public static void main(String[] args) {
        // Generics, varargs & boxing working together:
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer result = reduce(li, new IntegerAdder());
        print(result);

        result = reduce(li, new IntegerSubtracter());
        print(result);

        print(
                filter(li, new GreaterThan<>(4))
        );

        print(
                forEach(
                        li,
                        new MultiplyingIntegerCollector()
                ).result()
        );

        print(
                forEach(
                        filter(li, new GreaterThan<>(4)),
                        new MultiplyingIntegerCollector()
                ).result()
        );

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal("1.1", mc), new BigDecimal("2.2", mc),
                new BigDecimal("3.3", mc), new BigDecimal("4.4", mc));
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        print(rbd);

        print(
                filter(
                        lbd,
                        new GreaterThan<>(new BigDecimal(3))
                )
        );

        // Use the prime-generation facility of BigInteger:
        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        print(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        print(rbi);

        if (rbi != null) {
            // The sum of this list of primes is also prime:
            print(rbi.isProbablePrime(5));
        }


        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133)
        );
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        print(ral);

        print(transform(lbd, new BigDecimalUlp()));
    }
}