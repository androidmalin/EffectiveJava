package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_102_二叉树的层序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 102. 二叉树的层序遍历
 * 实现:非递归写法
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);

        System.out.println("非递归--二叉树的层序遍历:");
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        Solution solution = new Solution();

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(1));
        lists.add(Arrays.asList(2, 3));
        lists.add(Arrays.asList(4, 5, 6, 7));

        assertEquals(lists, solution.levelOrder(root));
    }
}
