package com.example.practice.questiones.tree.lc_0_二叉树遍历.后序.lc_145_二叉树后序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3);

        System.out.println("递归--二叉树的后序遍历:");
        List<Integer> list0 = TreeUtil.postOrder(root);
        System.out.println(list0);
        System.out.println(" ");

        List<Integer> list = solution.postorderTraversal(root);
        System.out.println("迭代1--二叉树的后序遍历:");
        System.out.println(list);

        List<Integer> list1 = solution.postorderTraversal2(root);
        System.out.println(" ");
        System.out.println("迭代2--二叉树的后序遍历:");
        System.out.println(list1);


        System.out.println("复习--二叉树的后序遍历:");
        List<Integer> post = solution.postorderTraversal_ReView1(root);
        System.out.println(post);
    }

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        Solution solution = new Solution();
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal(root));
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal2(root));
        assertEquals(TreeUtil.postOrder(root), solution.postorderTraversal_ReView1(root));
    }
}
