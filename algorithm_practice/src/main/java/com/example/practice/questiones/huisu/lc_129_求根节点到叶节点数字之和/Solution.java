package com.example.practice.questiones.huisu.lc_129_求根节点到叶节点数字之和;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3);
        TreeOperation.show(root);
        int sum = sumNumbers(root);
        System.out.println(sum);
    }


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 这道题中，二叉树的每条从根节点到叶子节点的路径都代表一个数字。
     * 其实，每个节点都对应一个数字，
     * 等于其父节点对应的数字乘以 *10* 再加上该节点的值（这里假设根节点的父节点对应的数字是 *0*）。
     * <p>
     * 只要计算出每个叶子节点对应的数字，然后计算所有叶子节点对应的数字之和，即可得到结果。
     * <p>
     * 可以通过深度优先搜索和广度优先搜索实现。
     * <p>
     * 方法一：深度优先搜索
     * <p>
     * 深度优先搜索是很直观的做法。
     * 从根节点开始，遍历每个节点，如果遇到叶子节点，
     * 则将叶子节点对应的数字加到数字之和。
     * 如果当前节点不是叶子节点，则计算其子节点对应的数字，然后对子节点递归遍历。
     * <p>
     * 复杂度分析
     * - 时间复杂度：O(n)，其中 n 是二叉树的节点个数。对每个节点访问一次。
     * - 空间复杂度：O(n)，其中 n 是二叉树的节点个数。
     * 空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(n)。
     */
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            int left = dfs(root.left, sum);
            int right = dfs(root.right, sum);
            return left + right;
        }
    }
}
