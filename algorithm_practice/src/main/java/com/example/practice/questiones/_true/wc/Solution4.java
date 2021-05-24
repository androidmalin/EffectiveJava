package com.example.practice.questiones._true.wc;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {


    public static void main(String[] args) {
        /*
         * ```1```
         * ``/`\``
         * `2```3`
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        //[1, 2, 3]
        Solution4 solution4 = new Solution4();
        List<Integer> result = solution4.pre(root);
        System.out.println(result);
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<Integer> pre(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

}
