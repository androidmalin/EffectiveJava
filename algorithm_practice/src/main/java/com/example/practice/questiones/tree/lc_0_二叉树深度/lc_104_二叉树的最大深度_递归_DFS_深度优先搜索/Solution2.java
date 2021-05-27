package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * website test pass ✅
     */
    public int maxDepth(TreeNode root) {
        //1.终止条件
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
