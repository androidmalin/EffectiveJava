package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.review;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        TreeNode pre = root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (pre == null && current != null) return false;
            if (current != null) {
                queue.offer(current.left);
                queue.offer(current.right);
            }
            pre = current;
        }
        return true;
    }
}
