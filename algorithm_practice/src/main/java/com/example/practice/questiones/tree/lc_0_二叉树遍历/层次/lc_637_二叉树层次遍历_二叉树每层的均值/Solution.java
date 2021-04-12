package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_637_二叉树层次遍历_二叉树每层的均值;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * ``````3``````
 * ````/```\````
 * ``9```````20`
 * `/```````/```
 * 15``````7````
 * <p>
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/submissions/
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum = sum + currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            resultList.add(sum / size);
        }
        return resultList;
    }
}
