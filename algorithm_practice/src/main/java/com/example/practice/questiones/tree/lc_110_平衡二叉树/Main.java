package com.example.practice.questiones.tree.lc_110_平衡二叉树;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 3, 9, 10, null, null, 15, 7);
        TreeOperation.show(root);
        Assertions.assertTrue(new Solution().isBalanced(root));
        Assertions.assertTrue(new Solution2().isBalanced(root));
    }

}
