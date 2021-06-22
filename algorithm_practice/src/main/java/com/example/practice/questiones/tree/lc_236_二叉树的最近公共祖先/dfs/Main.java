package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeOperation.show(root);

        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;
        TreeNode node = new Solution().lowestCommonAncestor(root, p, q);

        System.out.println(" ");
        System.out.println("p:" + p + ",q:" + q + " lowestCommonAncestor=>" + node);

        Assertions.assertEquals(root.left, new Solution().lowestCommonAncestor(root, p, q));
        Assertions.assertEquals(root.left, new Solution2().lowestCommonAncestor(root, p, q));
        Assertions.assertEquals(root.left, new Solution3().lowestCommonAncestor(root, p, q));

    }
}
