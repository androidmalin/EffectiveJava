package com.example.practice.questiones.map.数字之和.lc_15_三数之和;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Solution {

    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    ///////////////////////////////////////
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> one = new ArrayList<>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[k]);
                        lists.add(one);
                    }
                }
            }
        }
        return lists;
    }
}

