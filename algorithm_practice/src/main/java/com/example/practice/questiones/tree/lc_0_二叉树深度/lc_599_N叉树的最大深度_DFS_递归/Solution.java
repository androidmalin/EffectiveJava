package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;


public class Solution {

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/solution/chao-100-java-di-gui-xie-fa-jiang-jie-ji-huwe/
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;

        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            max = Math.max(depth, max);
        }
        return max + 1;
    }
}