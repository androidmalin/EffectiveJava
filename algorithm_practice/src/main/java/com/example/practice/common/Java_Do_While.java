package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Java_Do_While {

    /**
     * do while:先执行循环体，再判断条件，条件满足，再继续执行循环体。
     * <p>
     * 简单一句话：do while：无论条件是否满足，循环体至少执行一次。
     */
    @Test
    public void test() {
        int x = 0;
        do {
            System.out.println(x);
            x++;
        } while (x < 0);
        Assertions.assertEquals(1, x);
    }

    @Test
    public void test1() {
        int x = 0;
        while (x < 0) {
            System.out.println(x);
            x++;
        }
        Assertions.assertEquals(0, x);
    }

    @Test
    public void test2() {
        int fast = 100;
        int slow = 0;
        while (true) {
            fast = fast - 1;
            slow = slow + 1;
            if (fast == slow) break;
        }
        System.out.println("fast:" + fast);
        System.out.println("slow:" + slow);
        Assertions.assertEquals(50, fast);
        Assertions.assertEquals(50, slow);
    }

    @Test
    public void test3() {
        int fast = 100;
        int slow = 0;
        do {
            fast = fast - 1;
            slow = slow + 1;
        } while (fast != slow);
        System.out.println("fast:" + fast);
        System.out.println("slow:" + slow);
        Assertions.assertEquals(50, fast);
        Assertions.assertEquals(50, slow);
    }
}
