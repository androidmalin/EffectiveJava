package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

    public static <T extends Comparable<T>> boolean isSame2(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null ^ list2 == null) return false;
        if (list1.size() != list2.size()) return false;
        int size = list1.size();
        for (int i = 0; i < size; i++) {
            T t1 = list1.get(i);
            T t2 = list2.get(i);
            if (t1 == null && t2 == null) continue;
            if (t1 == null ^ t2 == null) return false;
            if (t1.compareTo(t2) != 0) return false;
        }
        return true;
    }

    public static boolean isSame(List<Integer> list1, List<Integer> list2) {
        if (list1 == null && list2 == null) return true;
        if (list1 == null ^ list2 == null) return false;
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).intValue() != list2.get(i).intValue()) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        List<Integer> list1 = null;
        List<Integer> list2 = null;
        Assertions.assertTrue(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test2() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = null;
        Assertions.assertFalse(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test3() {
        List<Integer> list1 = null;
        List<Integer> list2 = new ArrayList<>();
        Assertions.assertFalse(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test4() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        Assertions.assertFalse(ListUtil.isSame2(list1, list2));
    }


    @Test
    public void test5() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        Assertions.assertTrue(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test6() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 2, 4);
        Assertions.assertFalse(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test7() {
        List<Integer> list1 = Arrays.asList(1, null, 3, 4);
        List<Integer> list2 = Arrays.asList(1, null, 2, 4);
        Assertions.assertFalse(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test8() {
        List<Integer> list1 = Arrays.asList(null, null, null, 4);
        List<Integer> list2 = Arrays.asList(null, null, null, 4);
        Assertions.assertTrue(ListUtil.isSame2(list1, list2));
    }

    @Test
    public void test9() {
        List<Integer> list1 = Arrays.asList(null, null, null, null);
        List<Integer> list2 = Arrays.asList(null, null, null, null);
        Assertions.assertTrue(ListUtil.isSame2(list1, list2));
    }
}
