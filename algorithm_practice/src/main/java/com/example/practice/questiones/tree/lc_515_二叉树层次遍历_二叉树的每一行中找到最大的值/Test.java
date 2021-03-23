package com.example.practice.questiones.tree.lc_515_二叉树层次遍历_二叉树的每一行中找到最大的值;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 在二叉树的每一行中找到最大的值。
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 */
public class Test {
    public static void main(String[] args) {
        TreeNode init = TreeCreateFactory.init(5, -73, null, -91, -22);
        Solution solution = new Solution();
        List<Integer> list = solution.largestValues(init);
        System.out.println(list);
    }
}
