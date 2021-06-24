package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.first_颜色标记法改进版;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {


    public List<Integer> preOrder(TreeNode root) {
        //root->left->right
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object object = stack.pop();
            if (object instanceof Integer) {
                int num = (int) object;
                list.add(num);
            } else if (object instanceof TreeNode) {
                TreeNode temp = (TreeNode) object;
                stack.push(temp.right);
                stack.push(temp.left);
                stack.push(temp.val);
            }
        }
        return list;
    }

    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    ////////////////////////////
    public List<Integer> inOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object object = stack.pop();
            if (object instanceof Integer) {
                int num = (int) object;
                list.add(num);
            } else if (object instanceof TreeNode) {
                //left->root->right
                TreeNode temp = (TreeNode) object;
                stack.push(temp.right);
                stack.push(temp.val);
                stack.push(temp.left);
            }
        }
        return list;
    }

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object object = stack.pop();
            if (object instanceof Integer) {
                int num = (int) object;
                list.add(num);
            } else if (object instanceof TreeNode) {
                TreeNode temp = (TreeNode) object;
                //left->right->root
                stack.push(temp.val);
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
        return list;
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, null, 4, null, 6, 7);
        TreeOperation.show(root);
        Assertions.assertTrue(ListUtil.isSame(new Solution2().preOrder(root), TreeUtil.preOrder(root)));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().inOrder(root), TreeUtil.inOrder(root)));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().postOrder(root), TreeUtil.postOrder(root)));
    }


}
