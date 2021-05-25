package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution {
    /**
     * ``````10`````
     * ````/```\````
     * ``8```````11`
     * `/`\`````````
     * 4```9````````
     * <p>
     * website test pass ✅
     */
    public boolean isValidBST(TreeNode root) {
        //1.left => (-∞, 最大值(上界))
        //2.right => (最少值(下界), +∞)
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return left && right;
    }

}