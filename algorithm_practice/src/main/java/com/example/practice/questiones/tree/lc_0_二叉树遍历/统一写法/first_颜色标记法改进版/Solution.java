package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.first_颜色标记法改进版;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的遍历
 * 非递归写法
 * <p>
 * <p>
 * white对应TreeNode数据类型，gray对应int数据类型，所以不需要额外的颜色标记
 * <p>
 * 访问过的节点就向stack里存入val，未访问过就存入节点
 * <p>
 * 但是相比官方题解的栈，
 * 缺点是每个节点实际上要入栈2次，因此时间复杂度为O(2n)，稍微比官方题解要慢一点，
 * 但是就代码可读性上来说，还是比官方的好很多
 * <p>
 * 很聪明的方法，虽然多占用了一些空间，但把三种遍历形式整合得简洁明了，
 * 相较于传统的方法（尤其针对后序遍历，后序的传统循环简直无情），
 * 大大增加了代码的简洁度和可读性
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了42.30%的用户
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/525555
 */
public class Solution {
    public List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                TreeNode currentNode = (TreeNode) object;
                //root - >left -> right
                stack.push(currentNode.right);
                stack.push(currentNode.left);
                stack.push(currentNode.val);
            } else if (object instanceof Integer) {
                resultList.add((Integer) object);
            }
        }
        return resultList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                // 中序遍历是(左->根->右),
                // 栈是后进先出
                // 要做逆序入栈(右-根-左)
                //left -> root -> right
                TreeNode currentNode = (TreeNode) object;
                stack.push(currentNode.right);
                stack.push(currentNode.val);
                stack.push(currentNode.left);
            } else if (object instanceof Integer) {
                resultList.add((Integer) object);
            }
        }
        return resultList;
    }

    public List<Integer> postOrderTraverse(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                TreeNode currentNode = (TreeNode) object;
                //left->right->root;
                stack.push(currentNode.val);
                stack.push(currentNode.right);
                stack.push(currentNode.left);
            } else if (object instanceof Integer) {
                resultList.add((Integer) object);
            }
        }
        return resultList;
    }

}