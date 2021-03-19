package com.example.practice.questiones.lc_102;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 实现:非递归写法
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        TreeNode root = TreeCreateFactory.getRootNode();

        System.out.println("非递归--二叉树的层序遍历:");
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }
}
