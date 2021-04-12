package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_199_二叉树从顶到底每行最右侧的值_DFS;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Main {

    /**
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * ```\```````\`
     * ````5```````4
     */
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, null, 5, null, null);
        Solution solution = new Solution();
        List<Integer> list = solution.rightSideView(root);
        System.out.println(list);
    }


    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        TreeOperation.show(root);
        List<Integer> actualList = new Solution().rightSideView(root);
        List<Integer> expectedList = Arrays.asList(1, 3, 7);
        assertEquals(expectedList, actualList);

        assertEquals(expectedList, new Solution().rightSideView(root));
    }
}
