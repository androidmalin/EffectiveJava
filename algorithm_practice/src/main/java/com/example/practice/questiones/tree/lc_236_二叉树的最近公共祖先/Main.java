package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeOperation.show(root);

        Solution solution = new Solution();
        TreeNode p = root.left;
        TreeNode q = root.left.right.right;
        System.out.println("p==" + p.val);
        System.out.println("q==" + q.val);
        TreeNode node = solution.lowestCommonAncestor(root, p, q);
        System.out.println(node);
    }
}
