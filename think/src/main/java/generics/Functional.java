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
            while (it.hasNext())
                result = combiner.combine(result, it.next());
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
     * 进阶阅读
     * 泛型的入门文档是 《Generics in the Java Programming Language》，作者是 Gilad Bracha，
     * 可以从 https://www.oracle.com/technetwork/java/javase/generics-tutorial-159168.pdf
     * <p>
     * Angelika Langer 的《Java Generics FAQs》是一份非常有帮助的资料，可以从
     * http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html 获取。
     * http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.pdf
     * <p>
     * 可以在Torgerson、Ernst、Hansen、vonderAhe、Bracha和Gafter所著的
     * 《AddingWiIdcardst0theJavaProgrammingLanguage》中找到更多有关通
     * 配符的知识，它位于www.j0t.fm/issues/issue—2004—12/articIe50
     * 所选习题的答案都可以在名为The Thinking in JavaAnnotated SoIution
     * Guide的电子文档中找到，读者可以从www.MindView.net处购买此文档。
     *
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