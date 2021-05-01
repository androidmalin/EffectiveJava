package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_递归;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 144. 二叉树的前序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        Assertions.assertEquals(TreeUtil.preOrder(root), solution.preorderTraversal(root));
    }
}
