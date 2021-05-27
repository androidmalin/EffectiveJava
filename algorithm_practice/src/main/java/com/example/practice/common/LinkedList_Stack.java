package com.example.practice.common;

import java.util.LinkedList;

public class LinkedList_Stack<T> {

    public final LinkedList<T> linkedList = new LinkedList<>();

    //入栈
    public void push(T obj) {
        linkedList.add(obj);
    }

    //出栈
    public T pop() {
        return linkedList.remove();
    }

    //查看栈顶元素
    public T peek() {
        return linkedList.getFirst();
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList_Stack<String> stack = new LinkedList_Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }
}
