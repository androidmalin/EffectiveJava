package com.example.practice.questiones.map.数字之和.lc_15_三数之和.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    public List<List<Integer>> threeSum(int[] nums) {
        //1.边界条件
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();

        //2.排序
        Arrays.sort(nums);
        int length = nums.length;

        //3.双指针
        for (int i = 0; i < length - 2; i++) {

            //int i = 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //while的循环条件, 不成立, 就停止了.
                    while (left < right) {
                        if (nums[left] != nums[++left]) break;
                    }
                    while (left < right) {
                        if (nums[right] != nums[--right]) break;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        //[0, 0, 0, 0, 0, 0, 0, 0]
        int[] array = {0, 0, 0, 0, 0, 0, 0, 0};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(array);
        System.out.println(lists);
    }
}
