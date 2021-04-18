package com.example.practice.questiones.map.数字之和.lc_167_两数之和II_输入有序数组.binary_search;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] actual = new Solution().twoSum(nums, target);

        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, actual);
    }
}
