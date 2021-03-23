package com.example.practice.questiones.tree.lc_589_N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderN(root, res);
        return res;
    }

    private void preorderN(Node root, List<Integer> res) {
        if (root == null) return;
        //根==>左边==>右边
        res.add(root.val);
        if (root.children == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            preorderN(root.children.get(i), res);
        }
    }
}


