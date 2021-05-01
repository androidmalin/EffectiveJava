package com.example.practice.review.tree;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.getTreeNode();
        Assertions.assertEquals(TreeUtil.levelOrder(root), solution.level(root));
        Assertions.assertEquals(TreeUtil.levelOrder(root), solution.level(root));
        Assertions.assertEquals(TreeUtil.preOrder(root), solution.preOrder(root));
        Assertions.assertEquals(TreeUtil.inOrder(root), solution.inOrder(root));
        Assertions.assertEquals(TreeUtil.postOrder(root), solution.postOrder(root));
    }
}
