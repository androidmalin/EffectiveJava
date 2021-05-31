package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_559_N叉树的最大深度_BFS_迭代;

import com.example.practice.common.Node;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * website test pass ✅
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        if (root.children.isEmpty()) return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node temp = queue.poll();
                if (temp.children != null && !temp.children.isEmpty()) {
                    for (Node node : temp.children) {
                        if (node != null) {
                            queue.offer(node);
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
