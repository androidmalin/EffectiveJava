package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_199_二叉树从顶到底每行最右侧的值_DFS;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 视频讲解
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 从根节点开始访问，根节点深度是0
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 每层第一个被访问的节点加入结果列表中.
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        helper(root.right, res, depth);
        helper(root.left, res, depth);
    }
}
