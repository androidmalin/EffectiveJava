package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeNode;

public class Solution3 {

    /**
     * plugin test pass ✅
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
