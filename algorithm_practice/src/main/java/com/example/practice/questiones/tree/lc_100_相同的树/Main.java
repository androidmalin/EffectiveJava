package com.example.practice.questiones.tree.lc_100_相同的树;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        TreeOperation.show(root);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        Assertions.assertTrue(solution.isSameTree(root, root1));
    }
}
