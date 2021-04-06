package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_递归;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = TreeCreateFactory.init(1, 2, 3);
        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("递归--二叉树的前序遍历:");
        System.out.println(list);
    }
}
