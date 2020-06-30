package arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

import static net.mindview.util.Print.print;

// Implementing Comparable in a class.
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;

    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return Integer.compare(i, rv.i);
    }

    private static Random r = new Random(47);

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100), r.nextInt(100));
            }
        };
    }

    /**
     * 16.7.3 数组元素的比较
     * 排序必须根据对象的实际类型执行比较操作。
     * <p>
     * 一种自然的解决方案是为每种不同的类型各编写一个不同的排序方法，
     * 但是这样的代码难以被新的类型所复用。
     * <p>
     * 程序设计的基本目标是"将保持不变的事物与会发生改变的事物相分离"，
     * 而这里，不变的是通用的排序算法，变化的是各种对象相互比较的方式。
     * <p>
     * 因此，不是将进行比较的代码编写成不同的子程序，而是使用策略设计模式。
     * <p>
     * 通过使用策略，可以将"会发生变化的代码"封装在单独的类中（策略对象），
     * <p>
     * 你可以将策略对象传递给总是相同的代码，这些代码将使用策略来完成其算法。
     * <p>
     * 通过这种方式，你能够用不同的对象来表示不同的比较方式，
     * 然后将它们传递给相同的排序代码。
     * <p>
     * Java有两种方式来提供比较功能。第一种是实现java.lang.Comparable接口，
     * <p>
     * 使你的类具有"天生"的比较能力。
     * <p>
     * 此接囗很简单，只有compareTo()方法。
     * <p>
     * 此方法接收另一个Object为参数，如果当前对象小于参数则返回负值，
     * <p>
     * 如果相等则返回零，如果当前对象大于参数则返回正值。
     * 下面的类实现了Comparable接囗，
     * 并且使用Java标准类库的方法Arrays.sort()演示了比较的效果：
     * <p>
     *
     * <p>
     * 在定义作比较的方法时，由你来负责决定将你的一个对象与另一个对象作比较的含义。
     * <p>
     * 这里在比较中只用到了i值，而忽略了j值。
     * <p>
     * generator()方法生成一个对象，此对象通过创建一个匿名内部类（见第8章）来实现Generator接囗。
     * <p>
     * 该例中构建CompType对象，并使用随机数加以初始化。
     * <p>
     * 在main()中，使用生成器填充CompType的数组，然后对其排序。
     * <p>
     * 如果没有实现Comparable接囗，调用so0的时候会抛出ClassCastException个运行时异常。
     * <p>
     * 因为sort()需要把参数的类型转变为Comparable。
     * <p>
     * 假设有人给你一个并没有实现Comparable的类，或者给你的类实现了
     * Comparable，但是你不喜欢它的实现方式，你需要另外一种不同的比较方法。
     * <p>
     * 要解决这个问题，可以创建一个实现了Comparator接囗（在第11章中简要介绍过）的单独的类。
     * <p>
     * 这是策略设计模式的一个应用实例。这个类有compare()和equals()两个方法。
     * <p>
     * 然而，不一定要实现equals()方法，除非有特殊的性能需要，
     * 因为无论何时创建一个类，都是间接继承自Object，而Object有equals()方法。
     * 所以只需用默认的Object的equals()方法就可以满足接囗的要求了。
     * <p>
     * <p>
     * Collections类（在下一章会详细介绍）包含reverseOrder()方法，该
     * 方法可以产生一个Comparator，它可以反转自然的排序顺序。
     * 这很容易应用于CompType：
     */
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], generator());
        print("before sorting:");
        print(Arrays.toString(a));

        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }
}
