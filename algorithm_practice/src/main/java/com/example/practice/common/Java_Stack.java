package com.example.practice.common;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Java_Stack {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
