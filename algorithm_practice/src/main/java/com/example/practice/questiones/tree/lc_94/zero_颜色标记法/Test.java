package com.example.practice.questiones.tree.lc_94.zero_颜色标记法;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(2, 1, 3);
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
