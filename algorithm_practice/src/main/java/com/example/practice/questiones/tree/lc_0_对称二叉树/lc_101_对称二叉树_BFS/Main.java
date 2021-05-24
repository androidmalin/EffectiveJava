package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_BFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 2, 3, 4, 4, 3);
        assertTrue(solution.isSymmetric(root));

        TreeNode root2 = TreeCreateFactory.init(false, 1, 2, 3);
        assertFalse(solution.isSymmetric(root2));
    }
}
