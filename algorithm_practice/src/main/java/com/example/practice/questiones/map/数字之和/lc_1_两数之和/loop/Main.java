package com.example.practice.questiones.map.数字之和.lc_1_两数之和.loop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] actual = new Solution().twoSum(nums, target);

        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
