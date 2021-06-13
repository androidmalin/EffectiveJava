package com.example.practice.questiones._true.lc_232_用栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue2 {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;


    public MyQueue2() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }


    public void push(int x) {
        inStack.push(x);
    }


    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }


    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }


    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
