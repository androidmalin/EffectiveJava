package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序2;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * plugin test passed ✅
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        //left->right->root
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
