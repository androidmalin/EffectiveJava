package com.example.practice.questiones.lc_199;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        Solution solution = new Solution();
        List<Integer> list = solution.rightSideView(root);
        System.out.println(list);

    }
}
