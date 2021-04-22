package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 1);
        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);
        System.out.println("  ");
    }

    @Test
    public void test0() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(-2147483648);
        boolean validBST = solution.isValidBST(root);
        Assertions.assertTrue(validBST);
        int min = Integer.MIN_VALUE;
        if (min == -2147483648) {
            System.out.println("xxx");
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 1);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(2, 1, 3);
        Assertions.assertTrue(solution.isValidBST(root));
    }
}
