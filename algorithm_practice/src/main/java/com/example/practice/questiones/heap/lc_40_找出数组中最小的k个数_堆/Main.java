package com.example.practice.questiones.heap.lc_40_找出数组中最小的k个数_堆;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(getArray(0, 1, 2, 3), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }

    @Test
    public void test() {
        int[] array = {3, 90, 20, 1, 2, 0};
        int[] expectedArray = {0, 1, 2};
        Assertions.assertArrayEquals(expectedArray, new Solution().getLeastNumbers(array, 3));
        Assertions.assertArrayEquals(expectedArray, new Solution2().getLeastNumbers(array, 3));
    }
}
