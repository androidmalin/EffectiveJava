package com.example.practice.common;

public class JavaLoop {
    public static void main(String[] args) {
        test();
        System.out.println(" ");
        test1();
        System.out.println(" ");
        test2();
        System.out.println(" ");
        test3();
        test5();
    }

    private static void test5() {
        long time = 304622870681L;
        long time2 = 285617516612L;
        long s = time - time2;
        long l = s / (1000 * 1000 * 1000);
        System.out.println(l);
    }

    private static void test() {
        {
            int i = 1;
            int j = i++;//先将i的原始值（1）赋值给变量j（1），然后i变量的值加1
            System.out.println("j=" + j); // 输出 j=1
            System.out.println("i=" + i); // 输出 i=2
        }

        {
            int i = 1;
            int j = ++i;//先将i变量的值加1，然后将i的当前值（2）赋值给变量j（2）
            System.out.println("j=" + j); // 输出 j=2
            System.out.println("i=" + i); // 输出 i=2
        }
    }

    /**
     * while loop without a body
     * https://stackoverflow.com/questions/25772774/while-loop-without-a-body-in-java
     */
    @SuppressWarnings("StatementWithEmptyBody")
    private static void test1() {
        int i = 100;
        int j = 200;
        while (++i < --j) ; // no body in this loop
        //100 + 49 = 149;
        //200 - 49 = 151;
        System.out.println("function1 i:" + i);
        System.out.println("function1 j:" + j);
    }

    private static void test2() {
        int i = 100;
        int j = 200;
        while (true) {
            i++;
            j--;
            if (i >= j) break;
        }
        System.out.println("function2 i:" + i);
        System.out.println("function2 j:" + j);
    }


    private static void test3() {
        int i = 100;
        int j = 200;
        do {
            i++;
            j--;
        } while (i < j);
        System.out.println("function3 i:" + i);
        System.out.println("function3 j:" + j);
    }
}
