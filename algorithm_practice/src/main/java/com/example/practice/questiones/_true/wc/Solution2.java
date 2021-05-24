package com.example.practice.questiones._true.wc;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {


    private final Map<Integer, TreeNode> parentMap = new HashMap<>();
    private final Map<TreeNode, Integer> visitedMap = new HashMap<>();

    public List<Integer> printBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();

        //1.
        makeParentNode(root);

        List<Integer> list = new ArrayList<>();

        //2.
        printLevel(root, list);
        return list;
    }

    private void printLevel(TreeNode root, List<Integer> list) {
        if (root == null) return;
        countVisitedNum(root, list);
        TreeNode cur = root;
        while (parentMap.get(cur.val) != null) {
            if ((cur.left == null && cur.right == null)) {
                cur = parentMap.get(cur.val);
                countVisitedNum(cur, list);
            } else if (cur.left != null && cur.right != null && visitedMap.get(cur) == 3) {
                cur = parentMap.get(cur.val);
                countVisitedNum(cur, list);
            } else if (cur.left != null && cur.right == null && visitedMap.get(cur) == 2) {
                cur = parentMap.get(cur.val);
                countVisitedNum(cur, list);
            } else if (cur.left == null && cur.right != null && visitedMap.get(cur) == 2) {
                cur = parentMap.get(cur.val);
                countVisitedNum(cur, list);
            } else {
                break;
            }
        }
        printLevel(root.left, list);
        printLevel(root.right, list);
    }

    private void countVisitedNum(TreeNode root, List<Integer> list) {
        int num = 0;
        if (visitedMap.containsKey(root)) {
            num = visitedMap.get(root) + 1;
        } else {
            num = num + 1;
        }
        visitedMap.put(root, num);
        list.add(root.val);
    }

    private void makeParentNode(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            makeParentNode(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            makeParentNode(root.right);
        }
    }
}
