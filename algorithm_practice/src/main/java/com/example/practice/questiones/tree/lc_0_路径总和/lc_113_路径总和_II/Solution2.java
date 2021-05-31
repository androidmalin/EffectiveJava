package com.example.practice.questiones.tree.lc_0_路径总和.lc_113_路径总和_II;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution/34805
 */
public class Solution2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root, sum, cur, ret);
        return ret;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ret) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ret.add(new ArrayList<>(cur));
        } else {
            pathSum(root.left, sum - root.val, cur, ret);
            pathSum(root.right, sum - root.val, cur, ret);
        }
        cur.remove(cur.size() - 1);
    }
}
