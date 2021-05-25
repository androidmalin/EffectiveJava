package com.example.practice.questiones.tree.lc_235_二叉搜索树的最近公共祖先;

import com.example.practice.common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Solution {

    /**
     * ````````````6````````````
     * `````````/`````\`````````
     * ``````2```````````8``````
     * ````/```\```````/```\````
     * ``0```````4```7```````9``
     * `````````/`\`````````````
     * ````````3```5````````````
     * 输入: root = [6, 2, 8, 0, 4, 7, 9, null, null, 3, 5], p = 2, q = 4
     * 输出: 2
     * <p>
     * <p>
     * ````````````6````````````
     * `````````/`````\`````````
     * ``````2```````````8``````
     * ````/```\```````/```\````
     * ``0```````4```7```````9``
     * `````````/`\`````````````
     * ````````3```5````````````
     * 输入: root = [6, 2, 8, 0, 4, 7, 9, null, null, 3, 5], p = 2, q = 8
     * 输出: 6
     * <p>
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     * <p>
     * website test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
