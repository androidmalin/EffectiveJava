package com.example.practice.common;

import java.util.LinkedList;

public class LinkedList_Queue<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    // 入队
    public void push(T obj) {
        linkedList.addLast(obj);
    }

    // 出队
    public T pop() {
        return linkedList.removeFirst();
    }

    public T peek() {
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        LinkedList_Queue<String> queue = new LinkedList_Queue<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());

    }
}
