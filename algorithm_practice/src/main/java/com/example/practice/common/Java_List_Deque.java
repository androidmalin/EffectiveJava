package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 113
 */
public class Java_List_Deque {

    @Test
    public void test1() {
        Deque<Integer> path = new ArrayDeque<>();
        path.offerLast(1);
        path.offerLast(2);
        path.offerLast(3);

        List<Integer> list = new ArrayList<>(path);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(i + " ==> " + list.get(i));
        }

        List<Integer> expectedList = Arrays.asList(1, 2, 3);
        Assertions.assertTrue(ListUtil.isSame(expectedList, list));

    }

    @Test
    public void test2() {
        Deque<Integer> path = new ArrayDeque<>();
        path.offerLast(3);
        path.offerLast(2);
        path.offerLast(1);

        List<Integer> list = new ArrayList<>(path);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(i + " ==> " + list.get(i));
        }

        List<Integer> expectedList = Arrays.asList(3, 2, 1);
        Assertions.assertTrue(ListUtil.isSame(expectedList, list));
    }
}
