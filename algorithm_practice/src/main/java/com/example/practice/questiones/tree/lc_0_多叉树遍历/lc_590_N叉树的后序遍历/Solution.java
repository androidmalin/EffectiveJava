package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_590_N叉树的后序遍历;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrderN(root, res);
        return res;
    }

    private void postOrderN(Node root, List<Integer> res) {
        //左==>右==>根
        if (root == null) return;
        for (int i = 0; root.children != null && i < root.children.size(); i++) {
            postOrderN(root.children.get(i), res);
        }
        res.add(root.val);
    }

    /**
     * 迭代
     * 颜色标记法
     */
    public List<Integer> postorder_color(Node root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof Node) {
                // 后序遍历是(left->right->root),
                // 栈是后进先出
                // 要做逆序入栈(root->right-left)
                Node currentNode = (Node) object;
                stack.push(currentNode.val);
                if (currentNode.children == null) continue;
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    Node tempNode = currentNode.children.get(i);
                    if (tempNode != null) stack.push(tempNode);
                }
            } else if (object instanceof Integer) {
                resultList.add((Integer) object);
            }
        }
        return resultList;
    }

    /**
     * 后序遍历
     * 迭代
     * 使用2个栈
     */
    public List<Integer> postorder_two_stack(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> s2 = new Stack<>();
        Stack<Node> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);
            for (int i = 0; node.children != null && i < node.children.size(); i++) {
                Node tempNode = node.children.get(i);
                if (tempNode != null) s1.push(tempNode);
            }
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().val);
        }
        return res;
    }
}
