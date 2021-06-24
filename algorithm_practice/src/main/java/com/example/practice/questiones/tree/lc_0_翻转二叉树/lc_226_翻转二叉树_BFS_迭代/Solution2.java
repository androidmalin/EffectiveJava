package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_BFS_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            swap(temp);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        //5.26 ✅
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, null, 7);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        TreeNode treeNode = solution2.invertTree(root);
        TreeOperation.show(treeNode);
    }
}
