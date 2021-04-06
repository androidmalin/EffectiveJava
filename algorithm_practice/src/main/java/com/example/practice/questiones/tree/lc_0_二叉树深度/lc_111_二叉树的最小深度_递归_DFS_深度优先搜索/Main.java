package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, null, 2, null, null, null, 3);
        Solution solution = new Solution();
        int minDepth = solution.minDepth(root);
        System.out.println("minDepth:" + minDepth);
        System.out.println(" ");
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, null, 2, null, null, null, 3);
        int depth = new Solution().minDepth(root);
        assertEquals(3, depth);
    }
}
