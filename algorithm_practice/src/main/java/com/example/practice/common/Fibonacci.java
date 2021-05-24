package com.example.practice.common;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Fibonacci {

    public int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacci2(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int first = 1, second = 1, sum = 0;
        while (n-- > 2) {
            //second+(first + second)
            System.out.println("n:" + n);
            sum = first + second;
            first = second;
            second = sum;
        }
        //first, second, sum,
        return sum;
    }


    @Test
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 30; i++) {
            boolean same = fibonacci.fibonacci(i) - fibonacci.fibonacci2(i) == 0;
            Assertions.assertTrue(same);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci2(5);
        test1();
    }

    // int j = i++;//先将i的原始值（1）赋值给变量j（1），然后i变量的值加1
    private static void test1() {
        int n = 3;
        while ((n--) > 2) {
            System.out.println("n1:" + n);
        }
        System.out.println("n2:" + n);
    }

    private static void test2() {
        int n = 3;
        while ((--n) > 2) {
            System.out.println("n1:" + n);
        }
        System.out.println("n2:" + n);
    }
}
