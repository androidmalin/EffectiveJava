package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_迭代_BFS_广度优先搜索;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return depth + 1;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}
