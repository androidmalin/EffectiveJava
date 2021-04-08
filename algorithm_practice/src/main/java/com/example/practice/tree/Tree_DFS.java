package com.example.practice.tree;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的深度优先遍历 DFS
 */
public class Tree_DFS {

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, null, null);

        System.out.println("DFS深度优先遍历");
        System.out.println("DFS 递归写法");
        dfs_recursion_traversal(root);
        System.out.println(" ");
        System.out.println("DFS 非递归写法");
        dfs_not_recursion_traversal(root);
    }

    /**
     * 前序遍历
     * DFS 递归写法
     */
    public static void dfs_recursion_traversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        dfs_recursion_traversal(root.left);
        dfs_recursion_traversal(root.right);
    }

    /**
     * 前序遍历
     * DFS 非递归写法
     */
    public static List<Integer> dfs_not_recursion_traversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode tempNode = stack.pop();
            resultList.add(tempNode.val);
            if (tempNode.right != null) stack.push(tempNode.right);
            if (tempNode.left != null) stack.push(tempNode.left);
        }
        System.out.println(resultList);
        return resultList;
    }

}
