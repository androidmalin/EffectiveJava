package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

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
        System.out.println("后序遍历1");
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

    @Test
    public void test_review() {
        TreeOperation.show(TreeUtil.getTreeNode());
        Solution2 solution2 = new Solution2();
        TreeNode invertTree = solution2.invertTree(TreeUtil.getTreeNode());
        TreeNode mirrorTree = TreeUtil.getMirrorTreeNode();
        assertEquals(TreeUtil.preOrder(mirrorTree), TreeUtil.preOrder(invertTree));
    }


    @Test
    public void test_review2() {
        TreeOperation.show(TreeUtil.getTreeNode());
        Solution3 solution3 = new Solution3();
        TreeNode pre = solution3.invert_pre(TreeUtil.getTreeNode());
        TreeNode in = solution3.invert_in(TreeUtil.getTreeNode());
        TreeNode post = solution3.invert_post(TreeUtil.getTreeNode());

        TreeNode mirrorTree = TreeUtil.getMirrorTreeNode();
        assertEquals(TreeUtil.preOrder(mirrorTree), TreeUtil.preOrder(pre));
        assertEquals(TreeUtil.preOrder(mirrorTree), TreeUtil.preOrder(in));
        assertEquals(TreeUtil.preOrder(mirrorTree), TreeUtil.preOrder(post));
    }
}
