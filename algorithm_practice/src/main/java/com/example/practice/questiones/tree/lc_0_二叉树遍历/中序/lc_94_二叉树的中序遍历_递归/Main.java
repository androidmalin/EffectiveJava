package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树的中序遍历_递归;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        Assertions.assertEquals(TreeUtil.inOrder(root), new Solution().inorderTraversal(root));
    }
}
