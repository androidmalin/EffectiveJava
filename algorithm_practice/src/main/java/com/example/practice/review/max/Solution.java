package com.example.practice.review.max;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + maxDepth(root.left) + maxDepth(root.right);
    }

    @SuppressWarnings("all")
    private int maxDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }

    @SuppressWarnings("all")
    private int maxDepth_BFS2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }
}
