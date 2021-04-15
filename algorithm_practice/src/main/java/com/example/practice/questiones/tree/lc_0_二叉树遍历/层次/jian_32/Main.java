package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.jian_32;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.levelOrder(null);
        System.out.println(Arrays.toString(ints));
    }
}
