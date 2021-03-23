package com.example.practice.questiones.tree.lc_94.first_颜色标记法改进版;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, null, 2, null, null, 3, null);
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
