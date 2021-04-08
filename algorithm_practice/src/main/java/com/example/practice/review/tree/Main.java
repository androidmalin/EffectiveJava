package com.example.practice.review.tree;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        List<List<Integer>> level = solution.level(root);
        System.out.println(level);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeUtil.getTreeNode();
        Assertions.assertEquals(TreeUtil.levelOrder(root), solution.level(root));
        Assertions.assertEquals(TreeUtil.preOrder(root), solution.preOrder(root));
        Assertions.assertEquals(TreeUtil.inOrder(root), solution.inOrder(root));
        Assertions.assertEquals(TreeUtil.postOrder(root), solution.postOrder(root));
    }
}
