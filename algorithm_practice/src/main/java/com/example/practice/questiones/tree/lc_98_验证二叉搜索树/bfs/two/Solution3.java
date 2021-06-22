package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.two;

import com.example.practice.common.TreeNode;

import java.util.Stack;

public class Solution3 {

    /**
     * plugin test passed ✅
     * TODO:需要反复练习
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        //inorder 递增
        double pre = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) return false;
            pre = temp.val;
            current = temp.right;
        }
        return true;
    }
}
