package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.first_颜色标记法改进版;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeUtil.getRandomTree();
        TreeOperation.show(root);

        Assertions.assertTrue(ListUtil.isSame(TreeUtil.preOrder(root), new Solution().preorderTraversal(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.inOrder(root), new Solution().inorderTraversal(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.postOrder(root), new Solution().postorderTraversal(root)));

        Assertions.assertTrue(ListUtil.isSame(TreeUtil.preOrder(root), new Solution2().preOrder(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.inOrder(root), new Solution2().inOrder(root)));
        Assertions.assertTrue(ListUtil.isSame(TreeUtil.postOrder(root), new Solution2().postOrder(root)));
    }

}
