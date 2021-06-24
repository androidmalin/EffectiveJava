package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_中序遍历;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * plugin test passed ✅
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        swap(root);
        invertTree(root.left);
        return root;
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
