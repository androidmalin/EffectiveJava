package com.example.practice.questiones.tree.lc_110_平衡二叉树;

import com.example.practice.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Solution2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean abs = Math.abs(height(root.left) - height(root.right)) <= 1;
        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        return abs && leftBalanced && rightBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
}
