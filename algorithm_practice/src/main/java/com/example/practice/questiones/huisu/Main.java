package com.example.practice.questiones.huisu;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(
                1,
                2, 5,
                3, null, null, null
        );
        TreeOperation.show(root);
        Main main = new Main();
        List<List<Integer>> list = main.pathSum(root, 6);
        System.out.println(list);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        find(root, sum, path, resultList);
        return resultList;
    }

    private void find(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> lists) {
        if (root == null) return;
        path.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                lists.add(new ArrayList<>(path));
            }
        }
        int target = sum - root.val;
        find(root.left, target, path, lists);
        find(root.right, target, path, lists);
        path.pollLast();
    }
}
