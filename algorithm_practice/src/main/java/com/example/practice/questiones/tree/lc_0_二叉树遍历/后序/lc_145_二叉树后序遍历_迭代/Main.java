package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_迭代;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeUtil.getRandomTree();
        TreeOperation.show(root);
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.postOrder(root), new Solution().postorderTraversal(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.postOrder(root), new Solution().postorderTraversal2(root)));
    }
}
