package org.javase.genericsexamples.test;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

    public static void main(String[] args) {
        List<Object> list = Arrays.asList("1s", "2s", "3s");
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        List<Double> list3 = Arrays.asList(1d, 2d, 3d);
        printList(list);
        printListAny(list2);
        printListAny(list3);
    }

    /**
     * printList方法的目标是打印任意类型的列表，但它没有达到这个目标--它只打印 Object 实例的列表。
     * 它不能打印List<Integer>、List<String>、List<Double>等，
     * 因为它们不是List<Object>的子类型。
     * <p>
     * 要写一个通用的printList方法，请使用List<?>。
     */
    public static void printList(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
    }

    /**
     * 需要注意的是，List<Object>和List<?>是不一样的。
     * 你可以在List<Object>中插入一个Object，或者Object的任何子类型。
     * <p>
     * 但你只能将空值插入到List<?>中。
     */
    public static void printListAny(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem + "");
        }
    }
}
