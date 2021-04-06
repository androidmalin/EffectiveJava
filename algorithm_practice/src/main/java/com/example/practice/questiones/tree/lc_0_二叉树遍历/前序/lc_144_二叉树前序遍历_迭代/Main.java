package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 144. 二叉树的前序遍历
 * 实现:非递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);

        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("非递归--二叉树的前序遍历:");
        System.out.println(list);

        List<Integer> list1 = solution.preorderTraversalDG(root);
        System.out.println("递归--二叉树的前序遍历:");
        System.out.println(list1);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        assertEquals(solution.preorderTraversalDG(root), solution.preorderTraversal(root));
    }

    @Test
    public void test1() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        List<Integer> resList = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        assertEquals(resList, solution.preorderTraversal(root));
        assertEquals(resList, solution.preorderTraversalDG(root));
    }

}
