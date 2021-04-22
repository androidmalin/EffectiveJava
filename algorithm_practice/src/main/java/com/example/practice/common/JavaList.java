package com.example.practice.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class JavaList {

    public static void main(String[] args) {


        System.out.println("  ");
        System.out.println("reverse list  ");
        reverse();
        System.out.println("  ");


        System.out.println("  ");
        System.out.println("listToArray  ");
        listToArray();
        System.out.println("  ");

        System.out.println("  ");
        System.out.println("arrayToList  ");
        arrayToList();
        System.out.println("  ");

        System.out.println("  ");
        System.out.println("getList  ");
        getList();
        System.out.println("  ");

        addFirstAndLast();
    }

    private static void addFirstAndLast() {
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

    /**
     * Collections.reverse
     */
    private static void reverse() {
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
    private static void listToArray() {
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

    private static void arrayToList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
    }

    private static void getList() {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(1));
        lists.add(Arrays.asList(2, 3));
        lists.add(Arrays.asList(4, 5, 6, 7));
        System.out.println(lists);
    }
}