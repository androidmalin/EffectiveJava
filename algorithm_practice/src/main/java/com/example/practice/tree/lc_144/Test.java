package com.example.practice.tree.lc_144;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(Arrays.asList(1, 2, 3, 4, 5, 6));
        TreeNode root = TreeCreateFactory.getRootNode();

        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("递归--前序遍历的结果为:");
        System.out.println(list);
    }
}
