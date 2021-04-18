package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_637_二叉树层次遍历_二叉树每层的均值.dfs;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();

        dfs(root, 0, counts, sums);

        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) return;
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level + 1, counts, sums);
        dfs(root.right, level + 1, counts, sums);
    }
}
