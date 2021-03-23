package com.example.practice.questiones.tree.lc_429_N叉树层次遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelList.add(node.val);

                for (int j = 0; node.children != null && j < node.children.size(); j++) {
                    Node tempNode = node.children.get(j);
                    if (tempNode != null) {
                        queue.offer(tempNode);
                    }
                }

            }
            resList.add(levelList);
        }
        return resList;
    }
}
