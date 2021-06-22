package com.example.practice.questiones.tree.lc_0_路径总和.lc_112_路径总和.bsf;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    /**
     * website test pass ✅
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queue.offer(root);
        queueValue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int num = queueValue.poll();
            if (temp.left == null && temp.right == null) {
                if (targetSum == num) return true;
            }
            if (temp.left != null) {
                queue.offer(temp.left);
                queueValue.offer(temp.left.val + num);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                queueValue.offer(temp.right.val + num);
            }
        }
        return false;
    }
}
