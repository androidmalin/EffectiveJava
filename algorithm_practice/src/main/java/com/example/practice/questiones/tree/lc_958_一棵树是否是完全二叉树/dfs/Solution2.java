package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

public class Solution2 {

    /**
     * website test pass ✅
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        int count = countNode(root);
        return helper(root, count, 1);
    }

    /**
     * idx=1: 2,3
     * idx=2: 4,5
     * idx=3: 6,7
     */
    private boolean helper(TreeNode root, int total, int idx) {
        //TODO:注意递归的终止条件呀
        if (root == null) return true;
        if (idx > total) return false;
        boolean left = helper(root.left, total, idx * 2);
        boolean right = helper(root.right, total, idx * 2 + 1);
        return left && right;
    }

    private int countNode(TreeNode root) {
        //TODO:最后要+1
        if (root == null) return 0;
        return countNode(root.left) + countNode(root.right) + 1;
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, null, 3);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        int totalNum = solution2.countNode(root);
        System.out.println(totalNum);
        boolean completeTree = solution2.isCompleteTree(root);
        System.out.println(completeTree);
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, null, 3);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        int totalNum = solution2.countNode(root);
        System.out.println(totalNum);
        boolean completeTree = solution2.isCompleteTree(root);
        System.out.println(completeTree);
    }

}
