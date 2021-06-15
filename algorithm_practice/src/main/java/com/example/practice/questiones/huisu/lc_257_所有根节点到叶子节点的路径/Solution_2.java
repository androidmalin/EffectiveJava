package com.example.practice.questiones.huisu.lc_257_所有根节点到叶子节点的路径;

import com.example.practice.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
public class Solution_2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> result = getPathList(root);
        return getPathString(result);
    }

    public List<List<Integer>> getPathList(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        everyTraverse(root, deque, result);
        return result;
    }


    private void everyTraverse(TreeNode root, Deque<Integer> deque, List<List<Integer>> lists) {
        if (root == null) return;
        deque.offerLast(root.val);
        if (root.left == null && root.right == null) {
            lists.add(new ArrayList<>(deque));
        }
        everyTraverse(root.left, deque, lists);
        everyTraverse(root.right, deque, lists);
        deque.pollLast();
    }

    public List<String> getPathString(List<List<Integer>> list) {
        if (list == null || list.size() == 0) return new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<Integer> oneList = list.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < oneList.size(); j++) {
                sb.append(oneList.get(j));
                sb.append("->");
            }
            String oneLine = sb.toString();
            oneLine = oneLine.substring(0, oneLine.lastIndexOf("->"));
            resultList.add(oneLine);
        }
        return resultList;
    }
}
