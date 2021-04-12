package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.dfs;

import com.example.practice.common.TreeNode;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205682/JavaC++Python-BFS-Solution-and-DFS-Soluiton/209403
 */
public class Solution {

    public boolean isCompleteTree(TreeNode root) {
        int total = countNodes(root);
        System.out.println("total:" + total);
        return helper(root, 1, total);
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private boolean helper(TreeNode root, int idx, int total) {
        if (root == null) return true;
        if (idx > total) return false;
        boolean left = helper(root.left, idx * 2, total);
        boolean right = helper(root.right, idx * 2 + 1, total);
        System.out.println("root" + root + "," + "left:" + left + ",right:" + right);
        return left && right;
    }
}
