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
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 1, 1);
        TreeOperation.show(root);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 2, 1, 3);
        TreeOperation.show(root);
        Assertions.assertTrue(solution.isValidBST(root));
    }
}
