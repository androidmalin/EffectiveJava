package org.javase.genericsexamples.test;


import java.util.ArrayList;
import java.util.List;

/**
 * 下界通配符将未知类型限制为特定类型或该类型的超类型。
 * 下界通配符用通配符字符('?')表示，后面是super关键字，然后是它的下界。<? super A>。
 * <p>
 * 注意：你可以为通配符指定一个上限，也可以指定一个下限，但不能同时指定。
 */
public class LowerBoundedWildcards {

    public static void main(String[] args) {
        List<Integer> objects = new ArrayList<>();
        addNumbers(objects);
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void test() {
        List<?> list = new ArrayList<>();
        List<? extends Number> lowerBoundedNumberList = new ArrayList<>();
        List<? extends Integer> lowerBoundedIntegerList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();


        List<? super Number> upperBoundedNumberList = new ArrayList<>();
        List<? super Integer> upperBoundedIntegerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        //0.
        integerList(integerList);

        //1.
        lowerBoundedIntegerList(lowerBoundedIntegerList);
        lowerBoundedIntegerList(integerList);

        //2.
        lowerBoundedNumberList(lowerBoundedNumberList);
        lowerBoundedNumberList(lowerBoundedIntegerList);
        lowerBoundedNumberList(integerList);
        lowerBoundedNumberList(numberList);

        //3.
        list(list);
        list(lowerBoundedNumberList);
        list(lowerBoundedIntegerList);
        list(integerList);


        //0.
        numberList(numberList);

        //1.
        upperBoundedNumberList(upperBoundedNumberList);
        upperBoundedNumberList(numberList);

        //2.
        upperBoundedIntegerList(upperBoundedIntegerList);
        upperBoundedIntegerList(upperBoundedNumberList);
        upperBoundedIntegerList(numberList);
        upperBoundedIntegerList(integerList);//

        //3.
        list(list);
        list(upperBoundedIntegerList);
        list(upperBoundedNumberList);
        list(numberList);
        list(integerList);

    }


    public static void integerList(List<Integer> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void lowerBoundedIntegerList(List<? extends Integer> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void lowerBoundedNumberList(List<? extends Number> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void list(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void upperBoundedIntegerList(List<? super Integer> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }


    public static void upperBoundedNumberList(List<? super Number> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void numberList(List<Number> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
