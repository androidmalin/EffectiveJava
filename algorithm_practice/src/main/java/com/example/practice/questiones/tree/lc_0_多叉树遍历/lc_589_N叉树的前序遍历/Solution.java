package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_589_N叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * 进阶：
 * <p>
 * 递归法很简单，你可以使用迭代法完成此题吗?
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderN(root, res);
        return res;
    }

    private void preorderN(Node root, List<Integer> res) {
        if (root == null) return;
        //根==>左边==>右边
        res.add(root.val);
        for (int i = 0; root.children != null && i < root.children.size(); i++) {
            preorderN(root.children.get(i), res);
        }
    }

    /**
     * 迭代
     * 颜色标记法
     */
    public List<Integer> preorder_color(Node root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof Node) {
                // 前序遍历是(root->left->right),
                // 栈是后进先出
                // 要做逆序入栈(right-left-root)
                Node currentNode = (Node) object;
                if (currentNode.children != null) {
                    for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                        Node tempNode = currentNode.children.get(i);
                        if (tempNode != null) stack.push(tempNode);
                    }
                }
                stack.push(currentNode.val);
            } else if (object instanceof Integer) {
                resultList.add((Integer) object);
            }
        }
        return resultList;
    }

    /**
     * 迭代
     * 栈
     */
    public List<Integer> preorder_stack(Node root) {
        //root->left->right
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            res.add(currentNode.val);
            if (currentNode.children != null) {
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    Node tempNode = currentNode.children.get(i);
                    if (tempNode != null) stack.push(tempNode);
                }
            }
        }
        return res;
    }
}


