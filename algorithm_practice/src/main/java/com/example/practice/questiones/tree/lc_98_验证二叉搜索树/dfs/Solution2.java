package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

public class Solution2 {

    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////
    ////////////////////////////////


    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(10, 8, 11, 4, 9);
        Solution2 solution2 = new Solution2();
        boolean validBST = solution2.isValidBST(root);
        System.out.println(validBST);
        System.out.println(" ");
    }

    /**
     * ``````10`````
     * ````/```\````
     * ``8```````11`
     * `/`\`````````
     * 4```9````````
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
