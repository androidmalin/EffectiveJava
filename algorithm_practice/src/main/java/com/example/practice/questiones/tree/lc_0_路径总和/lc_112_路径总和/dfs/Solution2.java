package com.example.practice.questiones.tree.lc_0_路径总和.lc_112_路径总和.dfs;

import com.example.practice.common.TreeNode;

public class Solution2 {

    /**
     * ``````10`````
     * ````/```\````
     * ``8```````11`
     * `/`\`````````
     * 4```9````````
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        return hasPathSum(root.left, targetSum - root.val) &&
                hasPathSum(root.right, targetSum - root.val);
    }
}
