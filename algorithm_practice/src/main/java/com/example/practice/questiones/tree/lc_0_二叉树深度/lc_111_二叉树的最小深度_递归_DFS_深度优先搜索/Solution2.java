package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution2 {
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left != null && root.right == null) return 1 + left;
        if (root.right != null && root.left == null) return 1 + right;
        return Math.min(left, right) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min = Integer.MAX_VALUE;

        if (root.left != null) {
            min = Math.min(minDepth2(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth2(root.right), min);
        }
        return min + 1;
    }

    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    ////////////////////////
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return height + 1;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
            height++;
        }
        return height;
    }

    @Test
    public void main() {
        TreeNode root = TreeCreateFactory.init(false, 1, null, 2, null, null, null, 3);
        TreeOperation.show(root);
        assertEquals(3, new Solution2().minDepth(root));
        assertEquals(3, new Solution2().minDepth2(root));
        assertEquals(3, new Solution2().minDepth3(root));

        TreeNode root1 = TreeCreateFactory.init(false, 1);
        TreeOperation.show(root1);
        assertEquals(1, new Solution2().minDepth(root1));
        assertEquals(1, new Solution2().minDepth2(root1));
        assertEquals(1, new Solution2().minDepth3(root1));
    }
}
