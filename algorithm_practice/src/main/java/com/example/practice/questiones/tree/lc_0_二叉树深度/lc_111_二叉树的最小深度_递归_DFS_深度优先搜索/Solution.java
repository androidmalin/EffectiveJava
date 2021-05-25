package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;


import com.example.practice.common.TreeNode;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    /**
     * 这个写法, 思路清晰,容易理解.
     * <p>
     * 递归结束条件
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     * <p>
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/li-jie-zhe-dao-ti-de-jie-shu-tiao-jian-by-user7208/
     * <p>
     * 这个讲解很好理解
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/111-er-cha-shu-de-zui-xiao-shen-du-di-gu-ztum/
     */
    /**
     * 注意,
     * ①.递归的终止条件有2个,
     * 1.root==null
     * 2.root.left==null && root.right ==null 叶子节点
     * <p>
     * 最小的循环单元
     * 注意左子树 和 右子树为空的情况.
     * <p>
     * ②.树高度的定义
     * <p>
     * plugin test pass ✅
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) return 1;

        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        if (root.left == null && root.right != null) return rightMin + 1;
        if (root.left != null && root.right == null) return leftMin + 1;

        //上面的2个if语句可以被简化为如下的一行
        //if (root.left == null || root.right == null)return leftMin + rightMin + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        //root.left != null && root.right != null
        return Math.min(leftMin, rightMin) + 1;
    }

}
