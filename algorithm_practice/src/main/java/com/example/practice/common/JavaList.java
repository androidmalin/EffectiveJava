package com.example.practice.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JavaList {

    /**
     * Collections.reverse
     */
    @Test
    public void reverse() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        Collections.reverse(list);

        System.out.println(list);
    }

    /**
     * list to array
     */
    @Test
    public void listToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void arrayToList() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        System.out.println(list);
    }

    @Test
    public void arrayToList2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
    }


    @Test
    public void getList() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(1));
        lists.add(Arrays.asList(2, 3));
        lists.add(Arrays.asList(4, 5, 6, 7));
        System.out.println(lists);
    }

    @Test
    public void addFirstAndLast() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("LinkedList addLast 1,2,3,4,5 ");
        System.out.println(list);
        System.out.println(" ");

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addFirst(1);
        list1.addFirst(2);
        list1.addFirst(3);
        list1.addFirst(4);
        list1.addFirst(5);
        System.out.println("LinkedList addFirst 1,2,3,4,5 ");
        System.out.println(list1);
    }
}
