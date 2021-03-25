package com.example.practice.questiones.tree.lc_111_二叉树的最小深度;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return height + 1;
                }
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            height++;
        }
        return height;
    }
}
