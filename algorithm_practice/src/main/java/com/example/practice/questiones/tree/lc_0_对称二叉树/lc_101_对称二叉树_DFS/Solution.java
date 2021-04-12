package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_DFS;


import com.example.practice.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```\````2``
 * `/`\``\```/`\`
 * 3```4`\``4```3
 */
public class Solution {

    /**
     * 视频讲解
     * https://www.bilibili.com/s/video/BV15b411V78B
     * <p>
     * 递归
     * 思路和算法:
     * 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
     * 因此，该问题可以转化为：两个树在什么情况下互为镜像？
     * <p>
     * 如果同时满足下面的条件，两个树互为镜像：
     * 它们的两个根结点具有相同的值
     * 每个树的右子树都与另一个树的左子树镜像对称
     * <p>
     * 1.node1.value = node2.value
     * 2.node1.left = node2.right
     * 3.node1.right = node2.left
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等

        //①.
        // 1
        //left == null && right == null


        //②
        //```1```
        //``/````
        //`2`````
        //
        //left != null && right == null

        //③
        //```1```
        //````\``
        //`````3`
        //
        //left == null && right != null


        //④
        //```1```
        //``/`\``
        //`2```3`
        //
        //left.val != right.val


        //⑤
        //left != null && right != null && left.val = right.val
        //```````````````````````````1````````````````````````````````````
        //```````````````````/```````````````\````````````````````````````
        //``````````````2(left)`````````````````2(right)```````````````
        //`````````````/`\```````````````````/````````````\`````````````
        //(left.left)3````4(left.right)```4(right.left)`````3(right.right)

        //①.
        if (left == null && right == null) return true;

        //②.
        if (left != null && right == null) return false;

        //③
        if (left == null && right != null) return false;

        //④
        if (left.val != right.val) return false;

        //⑤
        //left != null && right != null && left.val = right.val
        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
