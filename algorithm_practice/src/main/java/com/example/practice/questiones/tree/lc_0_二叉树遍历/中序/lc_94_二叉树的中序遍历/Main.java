package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树的中序遍历;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3);
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
