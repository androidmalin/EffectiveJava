package org.javase.genericsexamples.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd3(strings, "hello");
        String s = strings.get(0);
        System.out.println(s);
    }

    private static void unsafeAdd(List strings, Object object) {
        strings.add(object);
    }

    private static void unsafeAdd2(List<Object> strings, Object object) {
        strings.add(object);
    }

    private static void unsafeAdd3(List<String> strings, String str) {
        strings.add(str);
    }

    //不要使用原始类型，
    //1.第一个例外
    private static void classLiteral() {
        //反射参数类型
        //必须在类文字中使用原始类型。不允许使用参数化类型
        Class<?> listClazz = List.class;
        Class<?> arrayListClazz = ArrayList.class;
        Class<?> stringArrayClazz = String[].class;
        Class<?> intClazz = int.class;
        Class<?> doubleClazz = double.class;
    }

    //2.第二个例外
    private static void instanceOf(Object o) {
        if (o instanceof Set) {
            Set<?> set = (Set<?>) o;
        }
    }
}
