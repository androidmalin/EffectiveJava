package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_递归;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    /**
     * 可视化演示
     * https://alchemist-al.com/algorithms/binary-tree-postorder-traversal
     */
    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
