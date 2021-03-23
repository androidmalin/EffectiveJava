package com.example.practice.questiones.tree.lc_94_二叉树的中序遍历;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了95.20%的用户
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //左边==>根==>右边
        List<Integer> res = new ArrayList<>();
        middleOrder(root, res);
        return res;
    }

    private void middleOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        middleOrder(root.left, res);
        res.add(root.val);
        middleOrder(root.right, res);
    }
}