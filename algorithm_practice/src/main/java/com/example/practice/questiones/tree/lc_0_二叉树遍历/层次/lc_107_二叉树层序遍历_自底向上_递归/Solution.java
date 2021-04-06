package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_107_二叉树层序遍历_自底向上_递归;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 1);
        Collections.reverse(res);
        return res;
    }

    private void dfs(TreeNode root, ArrayList<List<Integer>> res, int index) {
        if (root == null) {
            return;
        }
        //如果index大于res大小，说明这一层没有对应的集合，需要新创建
        if (index > res.size()) {
            res.add(new ArrayList<>());
        }
        //将当前层的元素直接放到对应层的末尾即可
        res.get(index - 1).add(root.val);
        //继续遍历左右节点，同时将层高+1
        dfs(root.left, res, index + 1);
        dfs(root.right, res, index + 1);
    }
}
