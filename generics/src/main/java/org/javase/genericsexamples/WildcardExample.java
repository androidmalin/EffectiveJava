package org.javase.genericsexamples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juneau
 */
public class WildcardExample {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(4);
        intList.add(6);

        List<String> strList = new ArrayList<>();
        strList.add("two");
        strList.add("four");
        strList.add("six");

        List<Object> objList = new ArrayList<>();
        objList.add("two");
        objList.add("four");
        objList.add(strList);

        printList(intList);
        printList(strList);
        printList(objList);

        checkList(intList, 3);
        checkList(intList, "hello");
        checkList(objList, strList);
        checkList(strList, objList);

        checkNumber(intList, 3);
        // The following will not work since strList is not a List of Number types
        // checkNumber(strList, "three");
    }

    /**
     * This method will print a List of unknown type
     */
    public static <T> void printList(List<T> myList) {
        for (Object e : myList) {
            System.out.println(e);
        }
    }

    /**
     * 通配符
     * 某些情况下，编写指定未知类型的代码很有用。
     * 问号 (?) 通配符可用于使用泛型代码表示未知类型。
     * 通配符可用于参数、字段、局部变量和返回类型。
     * 但最好不要在返回类型中使用通配符，因为确切知道方法返回的类型更安全。
     * <p>
     * 假设我们想编写一个方法来验证指定的 List 中是否存在指定的对象。
     * 我们希望该方法接受两个参数：一个是未知类型的 List，另一个是任意类型的对象。
     */
    public static <T> void checkList(List<?> myList, T obj) {
        if (myList.contains(obj)) {
            System.out.println("The list " + myList + " contains the element: " + obj);
        } else {
            System.out.println("The list " + myList + " does not contain the element: " + obj);
        }
    }

    /**
     * 有时要使用上限或下限限制通配符。
     * 与指定带边界的泛型类型极其相似，指定 extends 或 super 关键字加上通配符，后面跟用于上限或下限的类型，即可声明带边界的通配符类型。
     * 例如，如果我们要更改 checkList 方法使其只接受扩展 Number 类型的 List，
     */
    @SuppressWarnings("SuspiciousMethodCalls")
    public static <T> void checkNumber(List<? extends Number> myList, T obj) {
        if (myList.contains(obj)) {
            System.out.println("The list " + myList + " contains the element: " + obj);
        } else {
            System.out.println("The list " + myList + " does not contain the element: " + obj);
        }
    }
}
