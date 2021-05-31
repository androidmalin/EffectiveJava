package com.example.practice.questiones.tree.lc_0_路径总和.lc_112_路径总和.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Assertions.assertTrue(new Solution().hasPathSum(root, 7));
        Assertions.assertTrue(new Solution().hasPathSum(root, 8));
        Assertions.assertTrue(new Solution().hasPathSum(root, 10));
        Assertions.assertTrue(new Solution().hasPathSum(root, 11));
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Assertions.assertFalse(new Solution().hasPathSum(root, 9));
        Assertions.assertFalse(new Solution().hasPathSum(root, 12));
        Assertions.assertFalse(new Solution().hasPathSum(root, 13));
        Assertions.assertFalse(new Solution().hasPathSum(root, 14));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(new Solution().hasPathSum(null, 10));
    }

    @Test
    public void test4() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Assertions.assertTrue(new Solution().hasPathSum(root, 7));
        Assertions.assertTrue(new Solution().hasPathSum(root, 8));
        Assertions.assertTrue(new Solution().hasPathSum(root, 10));
        Assertions.assertTrue(new Solution().hasPathSum(root, 11));
    }

    @Test
    public void test5() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        Assertions.assertFalse(new Solution().hasPathSum(root, 9));
        Assertions.assertFalse(new Solution().hasPathSum(root, 12));
        Assertions.assertFalse(new Solution().hasPathSum(root, 13));
        Assertions.assertFalse(new Solution().hasPathSum(root, 14));
    }

    @Test
    public void test6() {
        Assertions.assertFalse(new Solution().hasPathSum(null, 10));
    }
}
