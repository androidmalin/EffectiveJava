package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.first_颜色标记法改进版;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        Solution solution = new Solution();
        assertEquals(TreeUtil.preOrder(root), solution.preorderTraversal(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal(root));
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal(root));
    }

}
