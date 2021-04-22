package com.example.practice.questiones.tree.lc_110_平衡二叉树;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        boolean balanced = solution.isBalanced(root);
        System.out.println(balanced);
        Assertions.assertTrue(balanced);

        Main main  = new Main();
        boolean balanced1 = main.isBalanced(root);
        Assertions.assertTrue(balanced1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean height = Math.abs(height(root.left) - height(root.right)) <= 1;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return height && left && right;

    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;

    }


}
