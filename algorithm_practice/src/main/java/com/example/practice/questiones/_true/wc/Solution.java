package com.example.practice.questiones._true.wc;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入
 * ```1```
 * ``/`\``
 * `2```3`
 * 输出
 * 1 2 1 3 1
 * <p>
 * 输入
 * ``````1``````
 * ````/````````
 * ``2``````````
 * `/```````````
 * 3````````````
 * 输出
 * 1 2 3 2 1
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        TreeOperation.show(root);
        List<Integer> list = new Solution().pre(root);
        System.out.println(list);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 2, 1);
        boolean same = ListUtil.isSame(list, list1);
        Assertions.assertTrue(same);
    }
    
    public List<Integer> pre(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderTree(root, result);
        return result;
    }

    private void preOrderTree(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left != null) {
            preOrderTree(root.left, list);
            if (root.left != null || root.right != null) {
                list.add(root.val);
            }
        }
        if (root.right != null) {
            preOrderTree(root.right, list);
            if (root.left != null || root.right != null) {
                list.add(root.val);
            }
        }
    }

    private void preOrderTree2(TreeNode root, TreeNode lastNode, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        lastNode = root;
        if (root.left != null) {
            preOrderTree2(root.left, lastNode, list);
            if (lastNode.left != null || lastNode.right != null) {
                list.add(lastNode.val);
            }
        }
        if (root.right != null) {
            preOrderTree2(root.right, lastNode, list);
            if (lastNode.left != null || lastNode.right != null) {
                list.add(lastNode.val);
            }
        }
    }
}
