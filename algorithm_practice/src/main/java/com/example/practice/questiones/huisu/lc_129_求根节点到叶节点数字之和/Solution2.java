package com.example.practice.questiones.huisu.lc_129_求根节点到叶节点数字之和;

import com.example.practice.common.TreeNode;

/**
 * 求根节点到叶节点数字之和
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
public class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return num(root, 0);
    }

    private int num(TreeNode root, int preSum) {
        if (root == null) return 0;
        int currentSum = 10 * preSum + root.val;
        if (root.left == null && root.right == null) {
            return currentSum;
        } else {
            return num(root.left, currentSum) + num(root.right, currentSum);
        }
    }
}
