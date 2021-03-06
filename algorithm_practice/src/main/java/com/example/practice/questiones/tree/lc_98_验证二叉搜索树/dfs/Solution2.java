package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);
        return left && right;
    }
}
