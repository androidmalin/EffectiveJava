package com.example.practice.tree.lc_102;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeCreateFactory.init(Arrays.asList(1, 2, 3, 4, 5, 6));
        TreeNode root = TreeCreateFactory.getRootNode();

        System.out.println("广度优先遍历:");
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }
}
