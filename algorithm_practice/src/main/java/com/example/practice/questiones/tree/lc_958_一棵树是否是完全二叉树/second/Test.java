package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.second;

import com.example.practice.common.TreeCreateFactory;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, null, null, 5};
        System.out.println(solution.isCompleteTree(TreeCreateFactory.init(Arrays.asList(integers))));
    }
}
