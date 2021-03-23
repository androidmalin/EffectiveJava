package com.example.practice.questiones.tree.lc_226_翻转二叉树_递归_后序遍历;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        System.out.println("后序遍历");
        TreeNode newRoot = solution.invertTree(root);
        TreeOperation.show(newRoot);
    }
}
