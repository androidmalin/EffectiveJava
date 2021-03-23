package com.example.practice.questiones.tree.lc_104_二叉树的最大深度_迭代;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
 */
@SuppressWarnings("all")
public class Solution {
    public int maxDepth(TreeNode root) {
        return level(root);
    }

    /**
     * 复杂度分析
     * 时间复杂度:O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
     * 空间复杂度:此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到O(n)。
     */
    private int level(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            height++;
        }
        return height;
    }
}
