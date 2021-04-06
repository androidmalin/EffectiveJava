package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_515_二叉树层次遍历_二叉树的每一行中找到最大的值;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在二叉树的每一行中找到最大的值。
 * 示例：
 * 输入:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * 输出: [1, 3, 9]
 * <p>
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            resultList.add(Collections.max(levelList));
        }
        return resultList;
    }
}
