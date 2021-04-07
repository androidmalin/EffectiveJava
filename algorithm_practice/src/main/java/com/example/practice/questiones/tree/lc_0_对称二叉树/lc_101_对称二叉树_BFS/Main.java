package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_BFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 2, 3, 4, 4, 3);
        boolean mirror = new Solution().isSymmetric(root);
        System.out.println("isSymmetric:" + mirror);
        System.out.println(" ");

        Solution2 solution2 = new Solution2();
        boolean symmetric = solution2.isSymmetric(root);
        System.out.println("test ");
        System.out.println("isSymmetric:" + symmetric);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));
        assertTrue(solution.isSymmetric(root));


        Solution2 solution2 = new Solution2();
        assertTrue(solution2.isSymmetric(root));
    }
}
