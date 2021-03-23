package com.example.practice.questiones.tree.lc_144_二叉树前序遍历_递归;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //注意:这里使用的数组和官网不一致, 但是生成的二叉树形状是一致的.
        TreeNode root = TreeCreateFactory.init(1, null, 2, null, null, 3, null);

        List<Integer> list = solution.preorderTraversal(root);
        System.out.println("递归--二叉树的前序遍历:");
        System.out.println(list);
    }
}
