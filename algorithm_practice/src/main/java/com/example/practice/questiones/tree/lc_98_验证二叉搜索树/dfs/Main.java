package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 1);
        TreeOperation.show(root);
        assertFalse(new Solution().isValidBST(root));
        assertFalse(new Solution2().isValidBST(root));
        assertFalse(new Solution3().isValidBST(root));
    }

    @Test
    public void test1() {
        TreeNode root = TreeCreateFactory.init(2, 1, 3);
        TreeOperation.show(root);
        Assertions.assertTrue(new Solution().isValidBST(root));
        Assertions.assertTrue(new Solution2().isValidBST(root));
        Assertions.assertTrue(new Solution3().isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(2, 1);
        TreeOperation.show(root);
        Assertions.assertTrue(new Solution().isValidBST(root));
        Assertions.assertTrue(new Solution2().isValidBST(root));
        Assertions.assertTrue(new Solution3().isValidBST(root));
    }

    @Test
    public void test3() {
        TreeNode root = TreeCreateFactory.init(10, 8, 11, 4, 9);
        TreeOperation.show(root);
        Assertions.assertTrue(new Solution().isValidBST(root));
        Assertions.assertTrue(new Solution2().isValidBST(root));
        Assertions.assertTrue(new Solution3().isValidBST(root));

    }
}
