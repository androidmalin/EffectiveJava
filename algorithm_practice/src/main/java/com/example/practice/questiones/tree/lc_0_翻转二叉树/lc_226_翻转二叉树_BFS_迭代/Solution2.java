package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_BFS_迭代;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////

    /**
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
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        //层次,广度优先 BFS
        //Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            swap(tempNode);
            if (tempNode.left != null) queue.offer(tempNode.left);
            if (tempNode.right != null) queue.offer(tempNode.right);
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////
    ///////////


}
