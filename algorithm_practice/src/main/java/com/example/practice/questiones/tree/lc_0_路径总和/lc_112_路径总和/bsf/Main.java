package com.example.practice.questiones.tree.lc_0_路径总和.lc_112_路径总和.bsf;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 7);
        boolean b1 = solution.hasPathSum(root, 8);
        boolean b2 = solution.hasPathSum(root, 10);
        boolean b3 = solution.hasPathSum(root, 11);
        Assertions.assertTrue(b);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 9);
        boolean b1 = solution.hasPathSum(root, 12);
        boolean b2 = solution.hasPathSum(root, 13);
        boolean b3 = solution.hasPathSum(root, 14);
        Assertions.assertFalse(b);
        Assertions.assertFalse(b1);
        Assertions.assertFalse(b2);
        Assertions.assertFalse(b3);
    }

    @Test
    public void test3() {
        TreeNode root = null;
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 10);
        Assertions.assertFalse(b);
    }

    @Test
    public void test4() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum_(root, 7);
        boolean b1 = solution.hasPathSum_(root, 8);
        boolean b2 = solution.hasPathSum_(root, 10);
        boolean b3 = solution.hasPathSum_(root, 11);
        Assertions.assertTrue(b);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }

    @Test
    public void test5() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum_(root, 9);
        boolean b1 = solution.hasPathSum_(root, 12);
        boolean b2 = solution.hasPathSum_(root, 13);
        boolean b3 = solution.hasPathSum_(root, 14);
        Assertions.assertFalse(b);
        Assertions.assertFalse(b1);
        Assertions.assertFalse(b2);
        Assertions.assertFalse(b3);
    }

    @Test
    public void test6() {
        TreeNode root = null;
        Solution solution = new Solution();
        boolean b = solution.hasPathSum_(root, 10);
        Assertions.assertFalse(b);
    }
}
