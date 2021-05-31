package com.example.practice.questiones._true.wc_二叉树_遍历回溯;

import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        TreeOperation.show(root);
        List<Integer> pre = new Solution2().pre(root);
        System.out.println(pre);
    }

    private final Map<Integer, TreeNode> parentMap = new HashMap<>();
    private final Map<TreeNode, Integer> visitedMap = new HashMap<>();

    public List<Integer> pre(TreeNode root) {
        if (root == null) return new ArrayList<>();

        //1.
        makeParentNode(root);

        List<Integer> list = new ArrayList<>();

        //2.
        printLevel(root, list);
        return list;
    }

    //root->left->right
    private void printLevel(TreeNode root, List<Integer> list) {
        if (root == null) return;
        countVisitedNum(root, list);
        TreeNode cur = root;
        while (parentMap.get(cur.val) != null) {
            boolean leafNode = cur.left == null && cur.right == null;
            boolean visited3 = cur.left != null && cur.right != null && visitedMap.get(cur) == 3;
            boolean visited2 = cur.left != null && cur.right == null && visitedMap.get(cur) == 2;
            boolean visited22 = cur.left == null && cur.right != null && visitedMap.get(cur) == 2;
            if (leafNode || visited3 || visited2 || visited22) {
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
        int visitedCount = 0;
        if (visitedMap.containsKey(root)) {
            visitedCount = visitedMap.get(root) + 1;
        } else {
            visitedCount = visitedCount + 1;
        }
        visitedMap.put(root, visitedCount);
        list.add(root.val);
    }

    /**
     * ```1```
     * ``/`\``
     * `2```3`
     */
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
