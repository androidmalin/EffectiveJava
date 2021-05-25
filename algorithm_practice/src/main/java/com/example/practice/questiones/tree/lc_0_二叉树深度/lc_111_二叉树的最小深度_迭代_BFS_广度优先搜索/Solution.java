package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_迭代_BFS_广度优先搜索;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
@SuppressWarnings("all")
public class Solution {

    /**
     * 广度优先搜索
     * 思路及解法
     * 同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。
     * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。
     * 广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
     * <p>
     * 复杂度分析
     * 时间复杂度： O(N)，其中 N 是树的节点数。
     * 对每个节点访问一次。
     * <p>
     * 空间复杂度： O(N)，其中 N 是树的节点数。
     * 空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     * plugin test pass ✅
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //保障一次while中的子循环 将一层的节点,全部出队
                TreeNode currentNode = queue.poll();
                //遇到叶子节点
                if (currentNode.left == null && currentNode.right == null) {
                    return depth + 1;
                }
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }
}
