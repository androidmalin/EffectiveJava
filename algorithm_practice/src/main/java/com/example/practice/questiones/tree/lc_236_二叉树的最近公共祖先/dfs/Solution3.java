package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * plugin test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
