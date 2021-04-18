package com.example.practice.questiones.map.数字之和.lc_1_两数之和.map;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * nums = [2,7,11,15], target = 9
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (hashMap.containsKey(search)) {
                answer[0] = hashMap.get(search);
                answer[1] = i;
                return answer;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
