package com.example.practice.questiones.heap.lc_40_找出数组中最小的k个数_排序;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(getArray(3, 2, 1, 0), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }

    @Test
    public void test() {
        int[] array = {3, 2, 1, 0};
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(array, 3);
        int[] leastNumbers2 = solution.getLeastNumbers2(array, 3);

        int[] expectedArray = {0, 1, 2};
        Assertions.assertEquals(Arrays.toString(expectedArray), Arrays.toString(leastNumbers));
        Assertions.assertEquals(Arrays.toString(expectedArray), Arrays.toString(leastNumbers2));
    }
}
