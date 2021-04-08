package com.example.practice.questiones.heap.lc_239_滑动窗口最大值;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.maxSlidingWindow(getArray(1, 2, 3, 4), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4};
        int[] leastNumbers = solution.maxSlidingWindow(array, 3);
        int[] expectedArray = {3, 4};
        System.out.println(Arrays.toString(expectedArray));
        System.out.println(Arrays.toString(leastNumbers));
        Assertions.assertEquals(Arrays.toString(expectedArray), Arrays.toString(leastNumbers));
    }
}
