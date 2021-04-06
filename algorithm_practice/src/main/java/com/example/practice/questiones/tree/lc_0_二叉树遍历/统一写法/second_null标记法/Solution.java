package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.second_null标记法;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 非递归写法
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了42.30%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了91.14%的用户
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);  // that's the point!
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                resList.add(node.val);
            }
        }
        return resList;
    }
}