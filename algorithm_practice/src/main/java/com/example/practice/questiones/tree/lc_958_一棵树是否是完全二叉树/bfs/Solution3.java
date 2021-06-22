package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    /**
     * plugin test pass ✅
     * TODO:需要反复练习
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean reached = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                reached = true;
            } else {
                if (reached) return false;
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return true;
    }
}
