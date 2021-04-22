package com.example.practice.questiones.map.数字之和.lc_15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
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


    /**
     * https://leetcode-cn.com/problems/3sum/solution/suan-fa-si-wei-yang-cheng-ji-er-fen-cha-5bk43/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)

        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
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
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(array);
        System.out.println(lists);
    }
}

