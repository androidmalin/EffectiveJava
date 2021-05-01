package com.example.practice.review.min;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * plugin test ok
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        //root.left!=null && root.right!=null
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }


    /**
     * plugin test ok
     */
    @SuppressWarnings("all")
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                //leaf
                if (tempNode.left == null && tempNode.right == null) return 1 + minDepth;
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                size--;
            }
            minDepth++;
        }
        return minDepth;
    }
}
