package com.example.practice.questiones.huisu.lc_113._路径总和_II;

import com.example.practice.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        traverse(root, sum, path, res);
        return res;
    }

    private void traverse(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(path));
            }
        }
        int target = sum - root.val;
        traverse(root.left, target, path, res);
        traverse(root.right, target, path, res);
        path.pollLast();
    }
}