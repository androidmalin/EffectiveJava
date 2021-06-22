package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_BFS;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    private void addDebugLog(TreeNode left, TreeNode right) {
        System.out.println("left==" + left.val);
        System.out.println("right==" + right.val);
        if (left.left != null) {
            System.out.println(left.left.val);
        } else {
            System.out.println("left.left==null");
        }
        if (right.right != null) {
            System.out.println(right.right.val);
        } else {
            System.out.println("right.right==null");
        }
        if (left.right != null) {
            System.out.println(left.right.val);
        } else {
            System.out.println("left.right==null");
        }
        if (right.left != null) {
            System.out.println(right.left.val);
        } else {
            System.out.println("right.left==null");
        }
    }
}
