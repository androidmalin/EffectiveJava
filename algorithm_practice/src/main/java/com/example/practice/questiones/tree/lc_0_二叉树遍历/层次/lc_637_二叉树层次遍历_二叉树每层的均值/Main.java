package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_637_二叉树层次遍历_二叉树每层的均值;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/submissions/
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        Solution solution = new Solution();
        List<Double> list = solution.averageOfLevels(root);
        System.out.println(list);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        List<Double> actualList = new Solution().averageOfLevels(root);
        List<Double> expectedList = Arrays.asList(1.0, 2.5, 5.0);
        assertEquals(expectedList, actualList);
    }
}
