package com.example.practice.questiones.huisu.lc_257;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

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
// Related Topics 树 深度优先搜索
public class Solution {

    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////
    /////////////////////

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        traverse(root, sum, path, res);
        return res;
    }

    private void traverse(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList<>(path));
            }
        }
        int target = sum - root.val;
        traverse(root.left, target, path, res);
        traverse(root.right, target, path, res);
        path.pollLast();
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false,
                1,
                2, 3,
                4, null, 6, 7
        );
        TreeOperation.show(root);
        Solution solution = new Solution();
        List<List<Integer>> list = solution.printPath(root);
        System.out.println(list);

        List<String> list1 = getList(list);
        System.out.println(list1);
    }

    private List<String> getList(List<List<Integer>> originList) {
        if (originList == null || originList.size() == 0) return new ArrayList<>();
        int size = originList.size();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> list = originList.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j)).append("->");
            }
            String one = sb.toString();
            //1->2->4->
            String result_ = one.substring(0, one.lastIndexOf("->"));
            resultList.add(result_);
        }
        return resultList;
    }

    //[[1, 2, 4], [1, 3, 6], [1, 3, 7]]
    //["1->2->4", "1->3->6", "1->3->"]
    public List<List<Integer>> printPath(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        everyTraverse(root, deque, resultList);
        return resultList;
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

}
