package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.Stack;

public class Solution2 {

    /**
     * 二叉树的中序遍历非递归写法
     * ```2```
     * ``/`\``
     * `1```3`
     */
    public boolean isValidBST(TreeNode root) {
        //1.Boundary conditions
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        double pre = -Double.MAX_VALUE;
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

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(0);
        Solution2 solution = new Solution2();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);

        System.out.println("Double.MIN_VALUE:" + Double.MIN_VALUE);
        System.out.println(" ");
    }
}
