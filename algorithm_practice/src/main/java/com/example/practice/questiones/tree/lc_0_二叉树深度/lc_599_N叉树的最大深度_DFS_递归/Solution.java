package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;


public class Solution {

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/solution/chao-100-java-di-gui-xie-fa-jiang-jie-ji-huwe/
     */
    public int maxDepth(Node root) {
        return max(root);
    }

    private int max(Node root) {
        if (root == null) return 0;
        if (root.children.isEmpty()) return 1;
        int maxValue = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int currentMax = max(root.children.get(i));
            if (currentMax > maxValue) {
                maxValue = currentMax;
            }
        }
        return maxValue + 1;
    }
}