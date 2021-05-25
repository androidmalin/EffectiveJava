package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * website test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, q, p);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
