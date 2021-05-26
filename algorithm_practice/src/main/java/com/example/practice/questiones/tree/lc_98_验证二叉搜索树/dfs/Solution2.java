package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        //5.26✅
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean left = isValid(root.left, min, root.val);
        boolean right = isValid(root.right, root.val, max);
        return left && right;
    }


    /**
     * ``````10`````
     * ````/```\````
     * ``8```````11`
     * `/`\`````````
     * 4```9````````
     */
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 10, 8, 11);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        boolean validBST = solution2.isValidBST(root);
        System.out.println(validBST);

    }

}
