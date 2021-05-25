package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_559_N叉树的最大深度_BFS_迭代;


import com.example.practice.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int j = 0; node.children != null && j < node.children.size(); j++) {
                    if (node.children.get(j) != null) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}