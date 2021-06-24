package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_迭代;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 144. 二叉树的前序遍历
 * 实现:非递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getRandomTree();
        TreeOperation.show(root);
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.preOrder(root), new Solution().preorderTraversal(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.preOrder(root), new Solution2().preorderTraversal(root)));
    }

}
