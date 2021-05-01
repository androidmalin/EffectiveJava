package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_迭代;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        Solution solution = new Solution();
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal(root));
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal2(root));
    }
}
