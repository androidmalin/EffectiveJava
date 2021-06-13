package com.example.practice.questiones._true.lc_232_用栈实现队列;

import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        int num1 = queue.pop();
        int num2 = queue.pop();
        int num3 = queue.pop();
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
