package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * plugin test passed ✅
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        //left->right->root
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
