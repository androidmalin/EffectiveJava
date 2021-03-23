package com.example.practice.questiones.tree.lc_637_二叉树层次遍历_二叉树每层的均值;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/submissions/
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        Solution solution = new Solution();
        List<Double> list = solution.averageOfLevels(root);
        System.out.println(list);
    }
}
