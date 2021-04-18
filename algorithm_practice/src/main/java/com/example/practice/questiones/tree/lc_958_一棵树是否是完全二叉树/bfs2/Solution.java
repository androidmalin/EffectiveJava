package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs2;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ```````1
 * ``````/`\
 * `````2```3
 * ````/`\```\
 * ```4```5```6
 * 层序遍历序列为：[1, 2, 3, 4, 5, null, 6]，其中null出现在了6前面，所以不合法
 * <p>
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/hen-jian-dan-de-si-lu-dai-ma-hen-jian-ji-by-yuanyb/
 */
public class Solution {

    /**
     * 利用完全二叉树层序遍历时节点连续出现的性质，遍历到null之后再遍历到非null则说明不连续，记录prev很巧妙
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }
}
