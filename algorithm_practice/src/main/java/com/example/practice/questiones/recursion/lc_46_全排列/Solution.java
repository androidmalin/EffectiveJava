package com.example.practice.questiones.recursion.lc_46_全排列;

import java.util.List;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/permutations
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        Solution solution = new Solution();
//        List<List<Integer>> lists = solution.permute(nums);
//        System.out.println(lists);

        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        path.add(1);
        path.add(2);
        path.add(3);
        path.add(4);
        List<Integer> list = new ArrayList<>(path);
        res.add(list);
        System.out.println(res);

    }
}
