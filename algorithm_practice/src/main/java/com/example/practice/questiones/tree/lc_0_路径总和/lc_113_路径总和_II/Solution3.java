package com.example.practice.questiones.tree.lc_0_路径总和.lc_113_路径总和_II;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 3);
        TreeOperation.show(root);
        Solution3 solution3 = new Solution3();
        List<List<Integer>> list = solution3.pathSum(root, 7);
        System.out.println(list);
    }

    /**
     * plugin test passed ✅
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        path(list, deque, root, sum);
        return list;
    }

    private void path(List<List<Integer>> list, Deque<Integer> deque, TreeNode root, int sum) {
        if (root == null) return;
        deque.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                list.add(new ArrayList<>(deque));
            }
        } else {
            path(list, deque, root.left, sum - root.val);
            path(list, deque, root.right, sum - root.val);
        }
        deque.pollLast();
    }
}
