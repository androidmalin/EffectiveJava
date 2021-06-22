package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_559_N叉树的最大深度_BFS_迭代;

import com.example.practice.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    /**
     * plugin test pass ✅
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.poll();
                if (temp.children != null) {
                    for (int i = 0; i < temp.children.size(); i++) {
                        if (temp.children.get(i) != null) {
                            queue.offer(temp.children.get(i));
                        }
                    }
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
