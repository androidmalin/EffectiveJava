package com.example.practice.questiones.tree.lc_104_二叉树的最大深度_递归;

import com.example.practice.common.TreeNode;

/**
 * 给定一个二叉树,找出其最大深度。
 * 递归实现
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
 */
public class Solution {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(height)
     * <p>
     * 时间复杂度:O(n),其中n为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度:O(height),其中height表示二叉树的高度。
     * 递归函数需要栈空间,而栈空间取决于递归的深度,因此空间复杂度等价于二叉树的高度。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
