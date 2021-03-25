package com.example.practice.questiones.heap.lc_40;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.getLeastNumbers(getArray(3, 90, 20, 1, 2, 0), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }
}