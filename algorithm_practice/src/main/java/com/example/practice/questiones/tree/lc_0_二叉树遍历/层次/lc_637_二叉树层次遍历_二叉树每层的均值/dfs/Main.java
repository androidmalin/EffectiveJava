package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_637_二叉树层次遍历_二叉树每层的均值.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/submissions/
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(3, 9, 20, 15, null, 7, null);
        TreeOperation.show(root);
        List<Double> expectedList = Arrays.asList(3.0, 14.5, 11.0);
        Assertions.assertEquals(expectedList, new Solution().averageOfLevels(root));
    }
}
