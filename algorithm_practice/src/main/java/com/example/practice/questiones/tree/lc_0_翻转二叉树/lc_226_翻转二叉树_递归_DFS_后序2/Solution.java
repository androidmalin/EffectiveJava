package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序2;

import com.example.practice.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```````3``
 * `/`\`````/`\`
 * 4```5```6```7
 * <p>
 * To
 * <p>
 * ``````1``````
 * ````/```\````
 * ``3```````2``
 * `/`\`````/`\`
 * 7```6```5```4
 * <p>
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        //postorder
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
