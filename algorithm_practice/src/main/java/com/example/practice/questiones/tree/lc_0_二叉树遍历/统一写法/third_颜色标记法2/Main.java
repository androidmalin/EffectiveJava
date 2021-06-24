package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.third_颜色标记法2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        TreeOperation.show(root);
        Solution solution = new Solution();
        Assertions.assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal(root));
    }
}
