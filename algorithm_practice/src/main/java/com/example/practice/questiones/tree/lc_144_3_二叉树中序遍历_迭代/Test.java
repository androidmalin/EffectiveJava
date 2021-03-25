package com.example.practice.questiones.tree.lc_144_3_二叉树中序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 144. 二叉树的中序遍历
 * 实现:非递归
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        TreeNode root = TreeCreateFactory.getRootNode();

        List<Integer> list = solution.inorderTraversal(root);
        System.out.println("非递归--二叉树的中序遍历:");
        System.out.println(list);

        System.out.println("递归--二叉树的中序遍历:");
        List<Integer> list1 = solution.inorderTraversal2(root);
        System.out.println(list1);
    }
}
