package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, null, null, 5};
        System.out.println(solution.isCompleteTree(TreeCreateFactory.init(integers)));
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, null, null, 5);
        assertFalse(solution.isCompleteTree(root));
    }
}
