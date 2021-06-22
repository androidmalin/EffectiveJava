package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.two;

import com.example.practice.common.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution {

    /**
     * 二叉树的中序遍历非递归写法
     * ```2```
     * ``/`\``
     * `1```3`
     * <p>
     * website test pass ✅
     */
    public boolean isValidBST(TreeNode root) {
        //1.Boundary conditions
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        double pre = -Double.MAX_VALUE;//注意📢
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode tempNode = stack.pop();
            if (tempNode.val <= pre) return false;

            pre = tempNode.val;
            current = tempNode.right;
        }
        return true;
    }
}
