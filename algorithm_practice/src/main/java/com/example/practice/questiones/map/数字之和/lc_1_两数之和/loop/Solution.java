package com.example.practice.questiones.map.数字之和.lc_1_两数之和.loop;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class Solution {


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


    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
