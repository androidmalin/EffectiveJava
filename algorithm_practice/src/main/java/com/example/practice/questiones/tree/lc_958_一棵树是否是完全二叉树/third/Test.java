package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.third;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{
                1,
                2, 3,
                4, null, 5, null,
                null, null, null, null, null, 6, null, null};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));

        boolean completeTree = solution.isCompleteTree(root);
        System.out.println(completeTree);
    }
}
