package com.example.practice.questiones.tree.lc_111_二叉树的最小深度;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        int minDepth = solution.minDepth(root);
        System.out.println(minDepth);
    }
}
