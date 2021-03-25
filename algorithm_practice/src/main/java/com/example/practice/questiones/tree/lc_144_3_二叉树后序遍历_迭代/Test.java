package com.example.practice.questiones.tree.lc_144_3_二叉树后序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 二叉树的后序遍历
 * 实现:非递归
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        TreeNode root = TreeCreateFactory.getRootNode();


        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("非递归--二叉树的后序遍历:");
        System.out.println(list);

        List<Integer> list1 = solution.preorderTraversal2(root);
        System.out.println("非递归--二叉树的后序遍历:");
        System.out.println(list1);

        System.out.println("递归--二叉树的后序遍历:");
        List<Integer> list2 = solution.preorderTraversal3(root);
        System.out.println(list2);
    }
}
