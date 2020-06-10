package org.javase.genericsexamples.test;

public class GenericMethodsAndBoundedTypeParameters {


    /**
     * 有界类型参数是实现通用算法的关键。
     * 该方法的实现是直接的，但它不能编译，
     * 因为大于运算符(>)只适用于基元类型，如short、int、double、long、float、byte和char。
     * <p>
     * 你不能使用>运算符来比较对象。要解决这个问题，可以使用一个由 Comparable<T>接口绑定的类型参数。
     */
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public interface Comparable<T> {
        int compareTo(T o);
    }
}
