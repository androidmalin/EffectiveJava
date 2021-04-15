package com.example.practice.questiones.tree.lc_0_二叉树遍历.lc_112_二叉树路径总和;

import com.example.practice.common.TreeNode;

/**
 * 112. 路径总和
 * <p>
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
