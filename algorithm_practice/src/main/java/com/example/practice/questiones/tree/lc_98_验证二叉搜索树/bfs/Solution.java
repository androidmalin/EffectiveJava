package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if (res.size() == 0) return false;
        if (res.size() == 1) return true;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i + 1) <= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = root;
        int pre = Integer.MIN_VALUE;
        while (!queue.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                queue.offer(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode tempNode = queue.poll();
            int current = tempNode.val;
            if (current <= pre) return false;

            pre = tempNode.val;
            currentNode = tempNode.right;
        }
        return true;
    }
}
