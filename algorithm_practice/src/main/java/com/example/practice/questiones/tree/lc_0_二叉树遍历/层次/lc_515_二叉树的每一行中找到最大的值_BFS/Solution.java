package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_515_二叉树的每一行中找到最大的值_BFS;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 * <p>
 * ``````1``````
 * ````/```\````
 * ``3```````2``
 * `/`\```````\`
 * 5```3```````9
 * <p>
 * 输出: [1, 3, 9]
 * <p>
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Solution {
    /**
     * 代码参考
     * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/javadai-ma-bfshe-dfsliang-chong-jie-jue-si-lu-yi-j/
     */
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            resultList.add(max);
        }
        return resultList;
    }
}
