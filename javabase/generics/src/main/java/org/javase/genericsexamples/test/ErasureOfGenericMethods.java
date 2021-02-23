package org.javase.genericsexamples.test;

public class ErasureOfGenericMethods {


    // Counts the number of occurrences of elem in anArray.
    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem)) {
                ++cnt;
            }
        return cnt;
    }


    /**
     * Because T is unbounded, the Java compiler replaces it with Object:
     */
    public static int count2(Object[] anArray, Object elem) {
        int cnt = 0;
        for (Object e : anArray)
            if (e.equals(elem)) {
                ++cnt;
            }
        return cnt;
    }

    public static class Shape {

    }

    public static class Circle extends Shape {

    }

    public static class Rectangle extends Shape {

    }

    public static <T extends Shape> void draw(T shape) {

    }

    public static void draw2(Shape shape) {

    }
}
