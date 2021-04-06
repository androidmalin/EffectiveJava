package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);

        List<Integer> list = solution.postorderTraversal(root);
        System.out.println("迭代1--二叉树的后序遍历:");
        System.out.println(list);

        List<Integer> list1 = solution.postorderTraversal2(root);
        System.out.println(" ");
        System.out.println("迭代2--二叉树的后序遍历:");
        System.out.println(list1);

        System.out.println(" ");
        System.out.println("递归--二叉树的后序遍历:");
        List<Integer> list2 = solution.postorderTraversalDG(root);
        System.out.println(list2);
        System.out.println(" ");
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        assertEquals(solution.postorderTraversalDG(root), solution.postorderTraversal(root));
        assertEquals(solution.postorderTraversalDG(root), solution.postorderTraversal2(root));
    }

    @Test
    public void test1() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        List<Integer> resList = Arrays.asList(4, 5, 2, 6, 7, 3, 1);
        assertEquals(resList, solution.postorderTraversal(root));
        assertEquals(resList, solution.postorderTraversalDG(root));
    }
}
