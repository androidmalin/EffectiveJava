package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_迭代_BFS_广度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, null, 4, null);
        Solution solution = new Solution();
//        int minDepth = solution.minDepth(root);
//        System.out.println("minDepth:" + minDepth);
//        System.out.println(" ");
//
//        int minDepth_reView = solution.minDepth_ReView(root);
//        System.out.println("minDepth_reView:" + minDepth_reView);
//
//        int minDepth_reView2 = solution.minDepth_ReView2(root);
//        System.out.println("minDepth_ReView2:" + minDepth_reView2);

        int minDepth_reView3 = solution.minDepth_ReView3(root);
        System.out.println("minDepth_reView3:"+minDepth_reView3);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, null, null, 6, 7);
        int depth = new Solution().minDepth(root);
        assertEquals(2, depth);
    }
}
