package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树的中序遍历_递归;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 */
public class Solution {
    /**
     * website test pass ✅
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        //左边==>根==>右边
        List<Integer> res = new ArrayList<>();
        middleOrder(root, res);
        return res;
    }

    /**
     * 可视化演示
     * https://alchemist-al.com/algorithms/binary-tree-inorder-traversal
     */
    private void middleOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        middleOrder(root.left, res);
        res.add(root.val);
        middleOrder(root.right, res);
    }
}