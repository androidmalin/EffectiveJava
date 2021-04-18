package com.example.practice.questiones.tree.lc_235_二叉搜索树的最近公共祖先;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    /**
     * ````````````6````````````
     * `````````/`````\`````````
     * ``````2```````````8``````
     * ````/```\```````/```\````
     * ``0```````4```7```````9``
     * `````````/`\`````````````
     * ````````3```5````````````
     * <p>
     * 输入: root = [6, 2, 8, 0, 4, 7, 9, null, null, 3, 5], p = 2, q = 4
     * 输出: 2
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeOperation.show(root);

        Solution solution = new Solution();
        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;

        TreeNode node = solution.lowestCommonAncestor(root, p, q);

        System.out.println(" ");
        System.out.println("p:" + p + ",q:" + q + " lowestCommonAncestor=> " + node);

        Assertions.assertEquals(root.left, node);
    }
}
