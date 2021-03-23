package com.example.practice.questiones.tree.lc_94.zero_颜色标记法;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 非递归写法
 * <p>
 * 其核心思想如下：
 * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
 * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
 * 如果遇到的节点为灰色，则将节点的值输出。
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了42.30%的用户
 * 内存消耗：36.8 MB, 在所有 Java 提交中击败了31.45%的用户
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.empty()) {
            ColorNode colorNode = stack.pop();
            if (colorNode.node == null) continue;
            if (colorNode.color.equals("white")) {
                stack.push(new ColorNode(colorNode.node.right, "white"));
                stack.push(new ColorNode(colorNode.node, "gray"));
                stack.push(new ColorNode(colorNode.node.left, "white"));
            } else {
                res.add(colorNode.node.val);
            }
        }
        return res;
    }

    static class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }
}