package com.example.practice.common;

import java.util.List;

public class ListProcess {


    public static <T extends Comparable<T>> boolean isSame(List<T> expectedList, List<T> actualList) {
        if (expectedList == null && actualList == null) return true;
        if (expectedList == null ^ actualList == null) return false;
        if (expectedList.size() != actualList.size()) return false;
        int size = expectedList.size();
        for (int i = 0; i < size; i++) {
            T expected = expectedList.get(i);
            T actual = actualList.get(i);
            if (expected == null && actual == null) continue;
            if (expected == null ^ actual == null) return false;
            if (expected.compareTo(actual) != 0) return false;
        }
        return true;
    }

    /**
     * https://stackoverflow.com/a/1075699/3326683
     */
    public static <T> boolean isSame2(List<T> expectedList, List<T> actualList) {
        if (expectedList == null && actualList == null) return true;
        if (expectedList == null ^ actualList == null) return false;
        if (expectedList.size() != actualList.size()) return false;
        return expectedList.equals(actualList);
    }

    public static <T> boolean isSame3(List<T> expectedList, List<T> actualList) {
        if (expectedList == null && actualList == null) return true;
        if (expectedList == null ^ actualList == null) return false;
        if (expectedList.size() != actualList.size()) return false;
        return expectedList.toString().equals(actualList.toString());
    }

    public static <T extends Comparable<T>> boolean isSame4(List<List<T>> expectedLists, List<List<T>> actualLists) {
        if (expectedLists == null && actualLists == null) return true;
        if (expectedLists == null ^ actualLists == null) return false;
        if (expectedLists.size() != actualLists.size()) return false;
        int size = expectedLists.size();
        for (int i = 0; i < size; i++) {
            List<T> expectedList = expectedLists.get(i);
            List<T> actualList = actualLists.get(i);
            if (!isSame(expectedList, actualList)) return false;

        }
        return true;
    }
}
