package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if (res.size() == 0) return false;
        if (res.size() == 1) return true;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i + 1) <= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
