package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_515_二叉树的每一行中找到最大的值_DFS;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二叉树的每一行中找到最大的值。
 * DFS
 * 图文讲解
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/solution/javadai-ma-bfshe-dfsliang-chong-jie-jue-si-lu-yi-j/
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    //level表示的是第几层，集合res中的第一个数据表示的是
    // 第一层的最大值，第二个数据表示的是第二层的最大值……
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        //如果走到下一层了直接加入到集合中
        if (level == res.size()) {
            res.add(root.val);
        } else {
            //注意：我们的level是从0开始的，也就是说root是第0层，而集合list的下标是从0开始的，
            // Math.max(res.get(level), root.val)表示
            // 遍历到的第level层的root.val值和集合中的第level个元素的值哪个大，就要哪个。
            res.set(level, Math.max(res.get(level), root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
