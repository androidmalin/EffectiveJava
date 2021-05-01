package com.example.practice.questiones.array.lc_283_移动零;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {0, 1, 0, 3, 12};
        solution.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
