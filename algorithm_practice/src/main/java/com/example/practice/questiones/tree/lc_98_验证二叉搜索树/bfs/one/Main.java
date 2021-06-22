package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.one;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    @Test
    public void test0() {
        Solution solution = new Solution();
        //Integer.MIN_VALUE = -2147483648
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        boolean validBST = solution.isValidBST(root);
        Assertions.assertTrue(validBST);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 1, 1);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 2, 1, 3);
        Assertions.assertTrue(solution.isValidBST(root));
    }
}
