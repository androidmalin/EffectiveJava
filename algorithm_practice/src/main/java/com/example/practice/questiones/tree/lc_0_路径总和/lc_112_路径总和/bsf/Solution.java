package com.example.practice.questiones.tree.lc_0_路径总和.lc_112_路径总和.bsf;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * https://leetcode-cn.com/problems/path-sum/solution/leetcode-112-lu-jing-zong-he-ti-jie-by-cengsin/
 */
public class Solution {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentSum = queueValue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == currentSum) {
                    return true;
                }
            }
            if (currentNode.left != null) {
                queueNode.offer(currentNode.left);
                queueValue.offer(currentNode.left.val + currentSum);
            }
            if (currentNode.right != null) {
                queueNode.offer(currentNode.right);
                queueValue.offer(currentNode.right.val + currentSum);
            }
        }
        return false;
    }
}
