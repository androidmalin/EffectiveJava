package com.example.practice.review.lc_112;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode currentNode = queueNode.poll();
            int currentSum = queueValue.poll();
            if (currentNode.left == null && currentNode.right == null) {
                if (targetSum == currentSum) {
                    return true;
                }
            }
            if (currentNode.left != null) {
                queueNode.offer(currentNode.left);
                queueValue.offer(currentNode.left.val + currentSum);
            }
            if (currentNode.right != null) {
                queueNode.offer(currentNode.right);
                queueValue.offer(currentNode.right.val + currentSum);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode init = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(init, 7);
        System.out.println(b);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 7);
        boolean b1 = solution.hasPathSum(root, 8);
        boolean b2 = solution.hasPathSum(root, 10);
        boolean b3 = solution.hasPathSum(root, 11);
        Assertions.assertTrue(b);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 9);
        boolean b1 = solution.hasPathSum(root, 12);
        boolean b2 = solution.hasPathSum(root, 13);
        boolean b3 = solution.hasPathSum(root, 14);
        Assertions.assertFalse(b);
        Assertions.assertFalse(b1);
        Assertions.assertFalse(b2);
        Assertions.assertFalse(b3);
    }

    @Test
    public void test3() {
        TreeNode root = null;
        Solution solution = new Solution();
        boolean b = solution.hasPathSum(root, 10);
        Assertions.assertFalse(b);
    }

    @Test
    public void test4() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum2(root, 7);
        boolean b1 = solution.hasPathSum2(root, 8);
        boolean b2 = solution.hasPathSum2(root, 10);
        boolean b3 = solution.hasPathSum2(root, 11);
        Assertions.assertTrue(b);
        Assertions.assertTrue(b1);
        Assertions.assertTrue(b2);
        Assertions.assertTrue(b3);
    }

    @Test
    public void test5() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean b = solution.hasPathSum2(root, 9);
        boolean b1 = solution.hasPathSum2(root, 12);
        boolean b2 = solution.hasPathSum2(root, 13);
        boolean b3 = solution.hasPathSum2(root, 14);
        Assertions.assertFalse(b);
        Assertions.assertFalse(b1);
        Assertions.assertFalse(b2);
        Assertions.assertFalse(b3);
    }

    @Test
    public void test6() {
        TreeNode root = null;
        Solution solution = new Solution();
        boolean b = solution.hasPathSum2(root, 10);
        Assertions.assertFalse(b);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        //leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int res = targetSum - root.val;
        return hasPathSum2(root.left, res) || hasPathSum2(root.right, res);
    }


    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    public boolean has(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode temp = queueNode.poll();
            int cur = queueValue.poll();
            if (temp.left == null && temp.right == null) {
                if (cur == targetSum) {
                    return true;
                } else {
                    continue;
                }
            }
            if (temp.left != null) {
                queueNode.offer(temp.left);
                queueValue.offer(temp.left.val + cur);
            }
            if (temp.right != null) {
                queueNode.offer(temp.right);
                queueValue.offer(temp.right.val + cur);
            }
        }
        return false;
    }

    public boolean has2(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        return has2(root.left, targetSum - root.val) ||
                has2(root.right, targetSum - root.val);
    }

    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    public boolean has3(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int cur = queue1.poll();
            if (temp.left == null && temp.right == null) {
                if (cur == targetSum) {
                    return true;
                } else {
                    continue;
                }
            }
            if (temp.left != null) {
                queue.offer(temp.left);
                queue1.offer(cur + temp.left.val);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                queue1.offer(cur + temp.right.val);
            }
        }
        return false;
    }


    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    //////////
    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    ////////// //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    //    //////////
    public boolean has4(TreeNode root){
        return false;
    }


}
