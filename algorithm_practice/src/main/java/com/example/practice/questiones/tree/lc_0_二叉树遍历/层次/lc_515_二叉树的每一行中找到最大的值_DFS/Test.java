package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_515_二叉树的每一行中找到最大的值_DFS;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        //expand list size
        if (d == res.size()) {
            res.add(root.val);
        } else {
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }
}
