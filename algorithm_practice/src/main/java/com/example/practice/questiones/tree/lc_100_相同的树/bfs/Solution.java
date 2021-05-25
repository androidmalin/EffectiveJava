package com.example.practice.questiones.tree.lc_100_相同的树.bfs;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * <p>
 * https://leetcode-cn.com/problems/same-tree/solution/xiang-tong-de-shu-by-leetcode-solution/
 */
public class Solution {

    /**
     * website test pass ✅
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) return false;

            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;

            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;


            // 如果只有一个节点的左子节点为空，
            // 或者只有一个节点的右子节点为空，则两个二叉树的结构不同，因此两个二叉树一定不同；
            if (left1 == null && left2 != null) return false;
            if (left1 != null && left2 == null) return false;

            if (right1 == null && right2 != null) return false;
            if (right1 != null && right2 == null) return false;

            if (left1 != null) queue1.offer(left1);
            if (right1 != null) queue1.offer(right1);

            if (left2 != null) queue2.offer(left2);
            if (right2 != null) queue2.offer(right2);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
