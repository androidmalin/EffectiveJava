package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs2;

import com.example.practice.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution4 {

    private final Map<Integer, TreeNode> parent = new HashMap<>();
    private final Set<TreeNode> visited = new HashSet<>();

    /**
     * plugin test pass ✅
     * TODO:需要反复练习
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        makeParentNode(root);
        //回溯遍历,🔼 向上遍历
        while (p != null) {
            visited.add(p);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void makeParentNode(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left.val, root);
            makeParentNode(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            makeParentNode(root.right);
        }
    }
}
