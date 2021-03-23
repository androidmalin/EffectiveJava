package com.example.practice.questiones.tree.lc_590_N叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrderN(root, res);
        return res;
    }

    private void postOrderN(Node root, List<Integer> res) {
        //左==>右==>根
        if (root == null) return;
        if (root.children == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            postOrderN(root.children.get(i), res);
        }
        res.add(root.val);
    }
}
