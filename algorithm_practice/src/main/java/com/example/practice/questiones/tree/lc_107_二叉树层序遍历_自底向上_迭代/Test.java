package com.example.practice.questiones.tree.lc_107_二叉树层序遍历_自底向上_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/san-chong-shi-xian-tu-jie-107er-cha-shu-de-ceng-ci/
 */
public class Test {
    public static void main(String[] args) {
        TreeCreateFactory.init(3, 9, 20, null, null, 15, 7);
        TreeNode root = TreeCreateFactory.getRootNode();
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrderBottom(root);
        System.out.println(lists);
    }
}
