package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.third;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{
                1,
                2, 3,
                4, null, 5, null,
                null, null, null, null, null, 6, null, null};
        TreeNode root = TreeCreateFactory.init(integers);

        boolean completeTree = solution.isCompleteTree(root);
        System.out.println(completeTree);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{
                1,
                2, 3,
                4, null, 5, null,
                null, null, null, null, null, 6, null, null};
        TreeNode root = TreeCreateFactory.init(integers);
        assertFalse(solution.isCompleteTree(root));
    }
}
