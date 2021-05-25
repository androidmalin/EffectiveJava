package com.example.practice.questiones.tree.lc_236_二叉树的最近公共祖先.dfs2;

import com.example.practice.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {


    private final Map<Integer, TreeNode> map = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();

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

    /**
     * website test pass ✅
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        makeParent(root);
        while (p != null) {
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return root;
    }
}
