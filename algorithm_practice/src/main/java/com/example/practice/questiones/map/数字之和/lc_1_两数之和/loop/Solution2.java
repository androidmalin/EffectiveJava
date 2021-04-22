package com.example.practice.questiones.map.数字之和.lc_1_两数之和.loop;

public class Solution2 {
    /**
     * nums = [2,7,11,15], target = 9
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
