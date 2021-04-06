package com.example.practice.questiones.tree.lc_对称二叉树.lc_101_对称二叉树_递归;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {

        //[1,2,2,null,3,null,3]
        TreeNode root = TreeCreateFactory.init(1, 2, 2, null, 3, null, 3);
        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 2, null, 3, null, 3);
        assertFalse(new Solution().isSymmetric(root));
    }
}
