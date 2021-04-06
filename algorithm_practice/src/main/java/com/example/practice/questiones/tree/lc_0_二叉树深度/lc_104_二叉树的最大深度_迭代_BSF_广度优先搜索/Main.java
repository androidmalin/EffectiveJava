package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_迭代_BSF_广度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(root);
        System.out.println("maxDepth:" + maxDepth);
        System.out.println(" ");
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        int depth = new Solution().maxDepth(root);
        assertEquals(3, depth);
    }
}
