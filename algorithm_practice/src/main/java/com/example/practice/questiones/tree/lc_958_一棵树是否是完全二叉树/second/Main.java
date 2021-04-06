package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.second;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, null, null, 5};
        System.out.println(solution.isCompleteTree(TreeCreateFactory.init(Arrays.asList(integers))));
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));
        assertFalse(solution.isCompleteTree(root));
    }
}