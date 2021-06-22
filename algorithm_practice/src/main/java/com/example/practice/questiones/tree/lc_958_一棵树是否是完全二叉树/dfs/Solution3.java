package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.dfs;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * TODO:需要反复练习
     * 注意:递归方法参数的先后顺序.
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        int total = count(root);
        return complete(1, total, root);
    }

    /**
     * left: 2x
     * right: 2x+1
     */
    private boolean complete(int index, int total, TreeNode root) {
        if (root == null) return true;
        if (index > total) return false;
        boolean left = complete(index * 2, total, root.left);
        boolean right = complete(index * 2 + 1, total, root.right);
        return left && right;
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

}
