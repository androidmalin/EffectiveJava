package com.example.practice.questiones.tree.lc_100_相同的树.bfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = null;

        TreeNode root1 = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, null);
        Assertions.assertTrue(solution.isSameTree(root, root1));
    }

    @Test
    public void test2() {
        TreeNode root1 = TreeCreateFactory.init(1, 2, 3);
        TreeNode root2 = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean sameTree2 = solution.isSameTree2(root1, root2);
        System.out.println(sameTree2);
        Assertions.assertFalse(sameTree2);
    }
}
