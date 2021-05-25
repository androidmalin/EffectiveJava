package com.example.practice.review.lowest;

import com.example.practice.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {

    public TreeNode getLowestParentNode3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = getLowestParentNode3(root.left, p, q);
        TreeNode right = getLowestParentNode3(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private final Map<Integer, TreeNode> map = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();

    public TreeNode getLowestParentNode(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        makeParent(root);
        while (q != null) {
            visited.add(q.val);
            q = map.get(q.val);
        }
        while (p != null) {
            if (visited.contains(p.val)) {
                return p;
            }
            p = map.get(p.val);
        }
        return root;
    }

    /**
     * **1
     * / \
     * 2  3
     */
    private void makeParent(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left.val, root);
            makeParent(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            makeParent(root.right);
        }
    }
}
