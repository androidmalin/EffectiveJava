package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs2;

import com.example.practice.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    private final Map<Integer, TreeNode> parent = new HashMap<>();
    private final Set<TreeNode> visited = new HashSet<>();

    /**
     * plugin test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode q, TreeNode p) {
        if (root == null || root == q || root == p) return root;
        makeParent(root);
        while (q != null) {
            visited.add(q);
            q = parent.get(q.val);
        }
        while (p != null) {
            if (visited.contains(p)) {
                return p;
            }
            p = parent.get(p.val);
        }
        return null;
    }

    private void makeParent(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left.val, root);
            makeParent(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            makeParent(root.right);
        }
    }
}
