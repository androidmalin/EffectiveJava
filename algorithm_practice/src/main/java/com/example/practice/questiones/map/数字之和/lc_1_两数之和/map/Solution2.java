package com.example.practice.questiones.map.数字之和.lc_1_两数之和.map;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    /**
     * nums = [2,7,11,15], target = 9
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public int[] twoSum(int[] nums, int target) {
        //存放索引
        int[] result = new int[2];

        //k:数组中的数字
        //v:数字的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (map.containsKey(search)) {
                result[0] = map.get(search);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
