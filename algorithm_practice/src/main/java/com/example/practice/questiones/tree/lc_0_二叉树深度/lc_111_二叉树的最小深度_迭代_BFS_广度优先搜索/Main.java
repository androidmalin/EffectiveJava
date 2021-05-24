package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_迭代_BFS_广度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, null, null, 6, 7);
        TreeOperation.show(root);
        int depth = new Solution().minDepth(root);
        assertEquals(2, depth);
    }
}
