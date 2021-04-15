package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.jian_32;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回：
 * [3,9,20,15,7]
 * <p>
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            list.add(tempNode.val);
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


}
