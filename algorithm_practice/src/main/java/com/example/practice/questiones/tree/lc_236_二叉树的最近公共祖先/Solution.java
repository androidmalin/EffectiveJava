package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先;

import com.example.practice.common.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {

    /**
     * 解题思路：
     * 两个节点 p,q 分为两种情况：
     * <p>
     * p 和 q 在相同子树中
     * p 和 q 在不同子树中
     * 从根节点遍历，递归向左右子树查询节点信息
     * 递归终止条件：如果当前节点为空或等于 p 或 q，则返回当前节点
     * <p>
     * 递归遍历左右子树，如果左右子树查到节点都不为空，则表明 p 和 q 分别在左右子树中，因此，当前节点即为最近公共祖先；
     * 如果左右子树其中一个不为空，则返回非空节点。
     * <p>
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-jian-j/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
