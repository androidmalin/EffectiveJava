package com.example.practice.questiones.heap.lc_40_找出数组中最小的k个数_排序;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(getArray(3, 2, 1, 0), 4);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }
}
