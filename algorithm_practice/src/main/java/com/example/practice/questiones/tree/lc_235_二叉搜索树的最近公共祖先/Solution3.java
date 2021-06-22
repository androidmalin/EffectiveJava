package com.example.practice.questiones.tree.lc_235_二叉搜索树的最近公共祖先;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * plugin test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
