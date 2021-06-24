package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListUtil {

    public static void main() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<String> list2 = Arrays.asList("1", "2", "3");
        boolean equalList = isSame(list1, list2);
        System.out.println(equalList);
    }

    public static boolean isSame(final Collection<?> list1, final Collection<?> list2) {
        if (list1 == list2) return true;
        if (list1 == null ^ list2 == null) return false;
        if (list1.size() != list2.size()) return false;
        final Iterator<?> it1 = list1.iterator();
        final Iterator<?> it2 = list2.iterator();
        Object obj1;
        Object obj2;
        while (it1.hasNext() && it2.hasNext()) {
            obj1 = it1.next();
            obj2 = it2.next();
            if (obj1 == null && obj2 == null) continue;
            if (obj1 == null ^ obj2 == null) return false;
            if (!obj1.equals(obj2)) return false;
        }
        return !it1.hasNext() && !it2.hasNext();
    }

    @Test
    public void test() {
        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expectedList.add(new ArrayList<>(Arrays.asList(1, 5)));
        Assertions.assertFalse(ListUtil.isSame(expectedList, null));
    }

    @Test
    public void test1() {
        Assertions.assertTrue(ListUtil.isSame(null, null));
    }

    @Test
    public void test2() {
        List<Integer> list1 = new ArrayList<>();
        Assertions.assertFalse(ListUtil.isSame(list1, null));
    }

    @Test
    public void test3() {
        List<Integer> list2 = new ArrayList<>();
        Assertions.assertFalse(ListUtil.isSame(null, list2));
    }

    @Test
    public void test4() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        Assertions.assertFalse(ListUtil.isSame(list1, list2));
    }


    @Test
    public void test5() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test6() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 3, 2, 4);
        Assertions.assertFalse(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test7() {
        List<Integer> list1 = Arrays.asList(1, null, 3, 4);
        List<Integer> list2 = Arrays.asList(1, null, 2, 4);
        Assertions.assertFalse(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test8() {
        List<Integer> list1 = Arrays.asList(null, null, null, 4);
        List<Integer> list2 = Arrays.asList(null, null, null, 4);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test9() {
        List<Integer> list1 = Arrays.asList(null, null, null, null);
        List<Integer> list2 = Arrays.asList(null, null, null, null);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }

    @Test
    public void test10() {
        List<Float> list1 = Arrays.asList(1.0f, null, null, null);
        List<Float> list2 = Arrays.asList(1.0f, null, null, null);
        Assertions.assertTrue(ListUtil.isSame(list1, list2));
    }
}
