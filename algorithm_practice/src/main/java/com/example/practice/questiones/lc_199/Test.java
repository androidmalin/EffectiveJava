package com.example.practice.questiones.lc_199;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Test {
    public static void main(String[] args) {

        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        Solution solution = new Solution();
        List<Integer> list = solution.rightSideView(root);
        System.out.println(list);

    }
}
