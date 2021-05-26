package com.example.practice.questiones.tree.lc_100_相同的树.dfs;

import com.example.practice.common.TreeNode;

public class Solution2 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        if (p.val != q.val) return false;

        //5.26 ✅
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}
