package com.example.practice.questiones.tree.lc_101_对称二叉树_递归;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

public class Test {
    public static void main(String[] args) {

        //[1,2,2,null,3,null,3]
        TreeNode root = TreeCreateFactory.init(1, 2, 2, null, 3, null, 3);
        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
    }
}
