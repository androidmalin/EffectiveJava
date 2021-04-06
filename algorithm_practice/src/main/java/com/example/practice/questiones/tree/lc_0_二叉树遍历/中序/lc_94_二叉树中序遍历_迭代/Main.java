package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树中序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 144. 二叉树的中序遍历
 * 实现:非递归
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);

        List<Integer> list = solution.inorderTraversal(root);
        System.out.println("迭代--二叉树的中序遍历:");
        System.out.println(list);

        System.out.println("递归--二叉树的中序遍历:");
        List<Integer> list1 = solution.inorderTraversalDG(root);
        System.out.println(list1);
    }


    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        assertEquals(solution.inorderTraversalDG(root), solution.inorderTraversal(root));
    }

    @Test
    public void test1() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        List<Integer> resList = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assertEquals(resList, solution.inorderTraversalDG(root));
        assertEquals(resList, solution.inorderTraversal(root));
    }
}
