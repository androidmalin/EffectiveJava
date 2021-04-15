package com.example.practice.questiones.tree.lc_0_二叉树遍历.lc_112_二叉树路径总和;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(5, 4, 8, 11, null, 13, 9, 7, 2, null, null, null, null, null, 1);
        Solution2 solution2 = new Solution2();
        boolean b = solution2.hasPathSum(root, 22);
        System.out.println(b);
        //输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                System.out.println("left:" + now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                System.out.println("right:" + now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
