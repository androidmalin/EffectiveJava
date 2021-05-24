package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_515_二叉树的每一行中找到最大的值_DFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 在二叉树的每一行中找到最大的值。
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 */
public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 5, -73, null, -91, -22);
        TreeOperation.show(root);
        List<Integer> actualList = new Solution().largestValues(root);
        List<Integer> expectedList = Arrays.asList(5, -73, -22);
        assertEquals(expectedList, actualList);
    }
}
