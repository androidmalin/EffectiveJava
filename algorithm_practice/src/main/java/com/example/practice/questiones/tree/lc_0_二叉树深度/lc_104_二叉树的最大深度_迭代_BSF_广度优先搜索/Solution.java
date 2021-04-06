package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_迭代_BSF_广度优先搜索;

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
        return level2(root);
    }

    /**
     * 复杂度分析
     * 时间复杂度:O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
     * 空间复杂度:此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到O(n)。
     * <p>
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````/`\`
     * 4```5```6```7
     * <p>
     * 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，
     * 此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
     * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，
     * 我们需要将队列里的所有节点都拿出来进行拓展，
     * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，
     * 即我们是一层一层地进行拓展，最后我们用一个变量 depth 来维护拓展的次数，
     * 该二叉树的最大深度即为depth。
     */
    private int level(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            depth++;
        }
        return depth;
    }

    private int level2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}
