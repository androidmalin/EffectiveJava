package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isCompleteTree(TreeCreateFactory.init(1, 2, 3, 4, null, null, 5)));
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, null, null, 5);
        assertFalse(solution.isCompleteTree(root));
    }
}