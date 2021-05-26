package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_DFS;

import com.example.practice.common.TreeNode;

public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //5.26 ✅
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode root1, TreeNode root2) {
        //四种情况
        if (root1 == null && root2 == null) return true;
        if (root1 == null ^ root2 == null) return false;
        //root1!=null && root2!=null
        if (root1.val != root2.val) return false;
        boolean left = mirror(root1.left, root2.right);
        boolean right = mirror(root1.right, root2.left);
        return left && right;
    }


}
