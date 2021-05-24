package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_前序遍历;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode invertTree = solution.invertTree(TreeUtil.getTreeNode());
        TreeNode mirrorTree = TreeUtil.getMirrorTreeNode();
        assertTrue(TreeUtil.isSameTree(mirrorTree, invertTree));
    }
}
