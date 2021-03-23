package com.example.practice.questiones.tree.lc_104_二叉树的最大深度_递归;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1);
        Solution solution = new Solution();
        int i = solution.maxDepth(root);
        System.out.println(i);
    }
}
