package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_DFS;

import com.example.practice.common.TreeNode;

public class Solution2 {

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    public boolean isMirror(TreeNode root) {
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        //Termination conditions
        //1. left==null &&  right ==null;
        if (left == null && right == null) return true;

        //2. left!=null && right ==null;
        if (left != null && right == null) return false;

        //3. left ==null && right != null;
        if (left == null && right != null) return false;

        //4. left!=null && right !=null;
        if (left.val != right.val) return false;
        return mirror(left.right, right.left) && mirror(left.left, right.right);
    }


}
