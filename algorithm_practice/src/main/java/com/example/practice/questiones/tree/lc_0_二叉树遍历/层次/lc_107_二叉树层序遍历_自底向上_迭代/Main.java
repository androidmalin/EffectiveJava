package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_107_二叉树层序遍历_自底向上_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/san-chong-shi-xian-tu-jie-107er-cha-shu-de-ceng-ci/
 */
public class Main {
    public static void main(String[] args) {
        TreeCreateFactory.init(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeCreateFactory.getRootNode();
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(root);
        System.out.println(lists);
    }

    @org.junit.jupiter.api.Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(3, 9, 20, null, null, 15, 7);
        Solution solution = new Solution();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(15, 7));
        lists.add(Arrays.asList(9, 20));
        lists.add(Collections.singletonList(3));
        assertEquals(lists, solution.levelOrderBottom(root));
    }
}
