package com.example.practice.questiones.array.lc_283_移动零;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes
 */
public class Solution {

    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    //////////////////////////////////////
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        System.out.println("nums[left]:" + nums[left] + ",  nums[right]:" + nums[right]);
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {0, 1, 0, 3, 12};
        solution.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
