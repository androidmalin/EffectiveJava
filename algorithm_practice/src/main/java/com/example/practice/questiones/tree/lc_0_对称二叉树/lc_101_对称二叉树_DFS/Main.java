package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_DFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 2, 3, 4, 4, 3);
        TreeOperation.show(root);
        assertTrue(new Solution().isSymmetric(root));
        assertTrue(new Solution2().isSymmetric(root));
    }
}
