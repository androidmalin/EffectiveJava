package com.example.practice.questiones.heap.lc_239;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.maxSlidingWindow(getArray(1, 2, 3, 4), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }
}
