package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {


    /**
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````/```
     * 4```5```6````
     * <p>
     * website test pass ✅
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reached = false;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                reached = true;
            } else {
                if (reached) {
                    return false;
                }
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return true;
    }
}
