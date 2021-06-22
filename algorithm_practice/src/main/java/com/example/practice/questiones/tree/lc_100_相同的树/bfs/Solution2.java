package com.example.practice.questiones.tree.lc_100_相同的树.bfs;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()) {
            TreeNode temp1 = queue1.poll();
            TreeNode temp2 = queue2.poll();
            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null || temp2 == null) return false;
            if (temp1.val != temp2.val) return false;
            queue1.offer(temp1.left);
            queue1.offer(temp1.right);
            queue2.offer(temp2.left);
            queue2.offer(temp2.right);
        }
        return true;
    }
}
