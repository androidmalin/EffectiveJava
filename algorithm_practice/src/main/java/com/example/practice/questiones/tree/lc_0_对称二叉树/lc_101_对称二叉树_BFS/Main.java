package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_BFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 2, 3, 4, 4, 3);
        assertTrue(new Solution().isSymmetric(root));

        TreeNode root2 = TreeCreateFactory.init(1, 2, 3);
        assertFalse(new Solution().isSymmetric(root2));
    }


    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, 2, 2, 3, 4, 4, 3);
        assertTrue(new Solution2().isSymmetric(root));

        TreeNode root2 = TreeCreateFactory.init(1, 2, 3);
        assertFalse(new Solution2().isSymmetric(root2));
    }

    @Test
    public void test3() {
        TreeNode root = TreeCreateFactory.init(1,0);
        assertFalse(new Solution2().isSymmetric(root));
    }
}
