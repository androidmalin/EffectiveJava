package com.example.practice.questiones.tree.lc_144_2_二叉树前序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 实现:非递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        TreeNode root = TreeCreateFactory.getRootNode();

        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("非递归--二叉树的前序遍历:");
        System.out.println(list);
    }
}
