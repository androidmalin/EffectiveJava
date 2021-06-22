package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_DFS;

import com.example.practice.common.TreeNode;


/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```\````2``
 * `/`\``\```/`\`
 * 3```4`\``4```3
 */
public class Solution3 {

    /**
     * plugin test pass ✅
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
