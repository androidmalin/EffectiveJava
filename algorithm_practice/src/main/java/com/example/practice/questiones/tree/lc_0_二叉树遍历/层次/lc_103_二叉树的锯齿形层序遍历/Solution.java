package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_103_二叉树的锯齿形层序遍历;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
@SuppressWarnings("all")
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (lists.size() % 2 == 0) {
                    //root层, 加到队列尾部
                    levelList.addLast(tempNode.val);
                } else {
                    //加到队列首部
                    levelList.addFirst(tempNode.val);
                }
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            lists.add(levelList);
        }
        return lists;
    }
}
