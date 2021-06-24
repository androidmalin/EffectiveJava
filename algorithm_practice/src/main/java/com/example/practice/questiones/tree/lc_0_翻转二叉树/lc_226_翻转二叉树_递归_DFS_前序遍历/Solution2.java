package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_前序遍历;

import com.example.practice.common.TreeNode;

/**
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
 */
public class Solution2 {

    /**
     * plugin test passed ✅
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
