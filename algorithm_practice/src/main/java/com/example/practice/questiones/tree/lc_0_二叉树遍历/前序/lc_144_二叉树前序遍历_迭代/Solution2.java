package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_迭代;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);

        }
        return list;
    }
}
