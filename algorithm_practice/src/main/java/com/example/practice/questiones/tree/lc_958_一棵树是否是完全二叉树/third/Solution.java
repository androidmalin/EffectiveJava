package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.third;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ```````1
 * ``````/`\
 * `````2```3
 * ````/`
 * ```4``
 * 层序遍历序列为：[1, 2, 3, 4, 5, null, 6]，其中null出现在了6前面，所以不合法
 * <p>
 */
public class Solution {

    /**
     * 完全二叉树（Complete Binary Tree）:
     * 在一颗二叉树中，若除最后一层外的其余层都是满的，
     * 并且最后一层要么是满的，要么在右边缺少连续若干节点，
     * 则此二叉树为完全二叉树（Complete Binary Tree）
     * <p>
     * 判断一棵二叉树是否为完全二叉树，依据以下标准会使判断过程变得简单且易实现。
     * 1.按层遍历二叉树，从每层的左边向右边依次遍历所有的节点。
     * 2.如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false。
     * 3.如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回 false。
     * 4.遍历过程中如果不返回 false，则遍历结束后返回 true。
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode left;
        TreeNode right;
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            left = root.left;
            right = root.right;
            if (
                    (right != null && left == null) ||
                            (leaf && (left != null || right != null))

            ) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
