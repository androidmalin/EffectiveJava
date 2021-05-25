package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;


import com.example.practice.common.Node;

public class Solution2 {

    /**
     * website test pass ✅
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;
        int max = 0;
        for (Node node : root.children) {
            int height = maxDepth(node);
            max = Math.max(height, max);
        }
        return max + 1;
    }
}
