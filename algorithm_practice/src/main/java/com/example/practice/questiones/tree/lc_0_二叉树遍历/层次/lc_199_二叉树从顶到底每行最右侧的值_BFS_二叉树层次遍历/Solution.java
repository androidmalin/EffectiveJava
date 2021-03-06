package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_199_二叉树从顶到底每行最右侧的值_BFS_二叉树层次遍历;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入:[1,2,3,null,5,null,4]
 * 输出:[1, 3, 4]
 * 解释:
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```````3``
 * ```\```````\`
 * ````5```````4
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(levelList.get(levelList.size() - 1));
        }
        return resultList;
    }
}
