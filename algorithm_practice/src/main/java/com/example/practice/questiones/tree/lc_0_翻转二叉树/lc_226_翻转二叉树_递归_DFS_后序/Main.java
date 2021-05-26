package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    @Test
    public void test() {
        assertTrue(TreeUtil.isSameTree(TreeUtil.getMirrorTreeNode(), new Solution().invertTree(TreeUtil.getTreeNode())));
        assertTrue(TreeUtil.isSameTree(TreeUtil.getMirrorTreeNode(), new Solution2().invertTree(TreeUtil.getTreeNode())));
    }
}
