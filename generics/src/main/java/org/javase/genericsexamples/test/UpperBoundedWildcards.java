package org.javase.genericsexamples.test;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcards {

    /**
     * 您可以使用上界通配符来放松对变量的限制。
     * 例如，假设你想写一个方法，它可以工作在List<Integer>、List<Double>和List<Number>上。
     * 你可以通过使用一个上界通配符来实现。
     * 要声明一个上界通配符，请使用通配符('?')，然后是extends关键字，接着是它的上界。
     * 请注意，在此上下文中，extends在一般意义上是指 "扩展"（如类）或 "实现"（如接口）。
     * <p>
     * 编写适用于Number列表和Number子类型（如Integer、Double和Float）的方法。
     * 你会指定List<? extends Number>。
     * 术语List<Number>比List<? extends Number>限制性更强，
     * 因为前者只匹配Number类型的列表，而后者匹配Number类型的列表或其任何子类。
     * <p>
     * 在foreach子句中，elem变量对列表中的每个元素进行迭代。
     * 现在，在Foo类中定义的任何方法都可以用于elem。
     */
    public static void process(List<? extends Foo> list) {
        for (Foo elem : list) {
            elem.say();
        }
    }

    public static class Foo {
        public void say() {
            System.out.println("say");
        }
    }


    public void test() {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
