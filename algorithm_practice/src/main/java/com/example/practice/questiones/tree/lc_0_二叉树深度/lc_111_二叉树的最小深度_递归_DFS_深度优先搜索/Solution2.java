package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left != null && root.right == null) return 1 + left;
        if (root.right != null && root.left == null) return 1 + right;

        return Math.min(left, right) + 1;
    }
}
