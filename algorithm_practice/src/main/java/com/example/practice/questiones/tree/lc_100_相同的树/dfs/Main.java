package com.example.practice.questiones.tree.lc_100_相同的树.dfs;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = null;
        TreeOperation.show(root);
        System.out.println(" ");

        TreeNode root1 = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, null);
        TreeOperation.show(root1);
        Assertions.assertTrue(new Solution().isSameTree(root, root1));
        Assertions.assertTrue(new Solution2().isSameTree(root, root1));
        Assertions.assertTrue(new Solution3().isSameTree(root, root1));
    }
}
