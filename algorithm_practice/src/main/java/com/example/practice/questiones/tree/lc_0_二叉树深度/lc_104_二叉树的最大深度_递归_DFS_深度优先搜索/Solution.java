package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_104_二叉树的最大深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
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
     * <p>
     * <p>
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `````````/`\`
     * ````````6```7
     * <p>
     * 视频讲解
     * https://coding.imooc.com/lesson/82.html#mid=2681
     * 时间为:10:49~14:20
     * <p>
     * 官方讲解也很棒,有文字,动画演示,还有视频讲解
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
     */
    public int maxDepth(TreeNode root) {
        //递归终止条件:
        if (root == null) return 0;

        //递归逻辑:
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        //返回值:
        return Math.max(leftMax, rightMax) + 1;
    }
}
