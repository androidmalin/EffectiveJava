package com.example.practice.questiones.array.lc_283_移动零;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {

    @Test
    public void test() {
        int[] array = {0, 1, 0, 3, 12};
        System.out.println("原始:" + Arrays.toString(array));
        new Solution().moveZeroes(array);
        int[] expected = {1, 3, 12, 0, 0};
        System.out.println("转换:" + Arrays.toString(array));
        Assertions.assertArrayEquals(expected, array);
    }


    @Test
    public void test2() {
        int[] array = {0, 1, 0, 3, 12};
        System.out.println("原始:" + Arrays.toString(array));
        new Solution2().moveZeroes(array);
        int[] expected = {1, 3, 12, 0, 0};
        System.out.println("转换:" + Arrays.toString(array));
        Assertions.assertArrayEquals(expected, array);
    }
}
