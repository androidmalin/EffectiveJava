package com.example.practice.questiones.tree.lc_0_对称二叉树.lc_101_对称二叉树_BFS;


import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * ``````1``````
 * ````/```\````
 * ``2```\````2``
 * `/`\``\```/`\`
 * 3```4`\``4```3
 */
public class Solution {
    /**
     * website test pass ✅
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null) return false;
        if (root.right == null) return false;
        //root.left!=null && root.right !=null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //``````1``````
            //````/```\````
            //``2```````2``
            //```\`````/```
            //````4```4````
            //还不能下最终的结论, 还没有遍历完成
            if (left == null && right == null) continue;

            //``````1``````
            //````/```\````
            //``2```````2``
            //`/`\`````/```
            //3```4```4````
            if (left != null && right == null) return false;


            //``````1``````
            //````/```\````
            //``2```````2``
            //```\`````/`\`
            //````4```4```3
            if (left == null && right != null) return false;


            //``````1``````
            //````/```\````
            //``2```````3``
            if (left.val != right.val) return false;


            //``````1``````
            //````/```\````
            //``2```````2``
            //`/`\`````/`\`
            //3```4```4```3
            //left!=null && right!=null

            //成对进行比较
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
