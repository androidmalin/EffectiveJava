package com.example.practice.questiones.tree.lc_0_二叉树遍历.lc_110_平衡二叉树;

import com.example.practice.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * <p>
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean ads = Math.abs(height(root.left) - height(root.right)) <= 1;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return ads && left && right;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
