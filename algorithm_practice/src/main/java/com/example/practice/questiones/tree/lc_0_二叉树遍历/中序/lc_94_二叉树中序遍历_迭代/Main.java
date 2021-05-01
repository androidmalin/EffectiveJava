package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树中序遍历_迭代;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 144. 二叉树的中序遍历
 * 实现:非递归
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        TreeOperation.show(root);
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal(root));
    }
}
