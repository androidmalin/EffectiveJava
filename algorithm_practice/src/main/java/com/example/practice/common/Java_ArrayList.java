package com.example.practice.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Java_ArrayList {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integers = new ArrayList<>(list);
        System.out.println(integers);
    }

    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> integers = new ArrayList<>(list);
        System.out.println(integers);
    }

    @Test
    public void test3() {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        List<Integer> integers = new ArrayList<>(deque);
        System.out.println(integers);
    }

    @Test
    public void test4() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        List<Integer> integers = new ArrayList<>(deque);
        System.out.println(integers);
    }
}
