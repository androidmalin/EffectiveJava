package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````/`\`
     * 4```5```6```7
     * <p>
     * To
     * <p>
     * ``````1``````
     * ````/```\````
     * ``3```````2``
     * `/`\`````/`\`
     * 7```6```5```4
     */
    public TreeNode invert_pre(TreeNode root) {
        if (root == null) return root;
        //root->left->right;
        swap(root);
        invert_pre(root.left);
        invert_pre(root.right);
        return root;
    }

    public TreeNode invert_in(TreeNode root) {
        if (root == null) return root;
        //left->root->right;
        invert_in(root.left);
        swap(root);
        invert_in(root.left);
        return root;
    }

    public TreeNode invert_post(TreeNode root) {
        if (root == null) return root;
        //left->right->root;
        invert_post(root.left);
        invert_post(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}
