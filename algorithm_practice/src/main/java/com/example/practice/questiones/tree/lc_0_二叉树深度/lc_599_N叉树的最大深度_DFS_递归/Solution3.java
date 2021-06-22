package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;

import com.example.practice.common.Node;

public class Solution3 {

    /**
     * plugin test pass ✅
     * TODO:需要反复练习
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(maxDepth(root.children.get(i)), max);
        }
        return max + 1;
    }
}
