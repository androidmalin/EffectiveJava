package com.example.practice.questiones.tree.lc_110_平衡二叉树;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(true, 3, 9, 10, null, null, 15, 7);
        boolean balancedTree = TreeUtil.isBalancedTree(root);
        Assertions.assertTrue(balancedTree);
    }

}
