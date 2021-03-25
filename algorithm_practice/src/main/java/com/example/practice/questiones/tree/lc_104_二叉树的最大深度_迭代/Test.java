package com.example.practice.questiones.tree.lc_104_二叉树的最大深度_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, null, null, null, null, 6, null);
        Solution solution = new Solution();
        int i = solution.minDepth(root);
        System.out.println(i);
    }
}
