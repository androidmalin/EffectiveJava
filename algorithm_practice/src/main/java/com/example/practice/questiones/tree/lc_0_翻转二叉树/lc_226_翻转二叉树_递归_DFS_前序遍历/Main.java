package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_前序遍历;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        System.out.println("前序遍历");
        TreeNode newRoot = solution.invertTree(root);
        TreeOperation.show(newRoot);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode invertTree = solution.invertTree(TreeUtil.getTreeNode());
        TreeNode mirrorTree = TreeUtil.getMirrorTreeNode();
        assertEquals(TreeUtil.preOrder(mirrorTree), TreeUtil.preOrder(invertTree));
    }
}
