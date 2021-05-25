package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_迭代_BSF_广度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7);
        TreeOperation.show(root);
        assertEquals(3, new Solution().maxDepth(root));
        assertEquals(3, new Solution2().maxDepth(root));
    }
}
