package com.example.practice.questiones.tree.lc_98_验证二叉搜索树;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 1};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));
        assertFalse(solution.isValidBST(root));
    }
}
