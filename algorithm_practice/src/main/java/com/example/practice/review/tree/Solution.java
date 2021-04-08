package com.example.practice.review.tree;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> level(TreeNode root) {
        //1.检查参数
        if (root == null) return new ArrayList<>();
        //2.根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> lists = new ArrayList<>();
        //3.每次循环=>即:每次的节点加入一个集合
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            lists.add(levelList);
        }
        //4.返回结果
        return lists;
    }


    /**
     * pre
     * push:node=1✅
     * push:node=3✅, node=2✅, value=1✅
     * push:node=5✅, node=4✅, value=2✅
     * push:node=null, node=null, value=4✅
     * push:node=null, node=null, value=5✅
     * push:node=null, node=null, value=3✅
     */
    public List<Integer> preOrder(TreeNode root) {
        //1.参数检查
        if (root == null) return new ArrayList<>();

        //2.颜色标记法
        //使用一个栈,存储2种类型的数据
        Stack<Object> stack = new Stack<>();

        //3.加入根节点
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        //遍历所有元素
        while (!stack.empty()) {
            Object object = stack.pop();
            //System.out.println("pop:" + object+" isNode:"+(object instanceof TreeNode));
            if (object instanceof TreeNode) {
                TreeNode tempNode = (TreeNode) object;
                //root->left->right;
                stack.push(tempNode.right);
                stack.push(tempNode.left);
                stack.push(tempNode.val);
            } else if (object instanceof Integer) {
                list.add((Integer) object);
            }
        }
        return list;
    }


    public List<Integer> inOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                TreeNode tempNode = (TreeNode) object;
                //left->root->right;
                stack.push(tempNode.right);
                stack.push(tempNode.val);
                stack.push(tempNode.left);
            } else if (object instanceof Integer) {
                list.add((Integer) object);
            }
        }
        return list;
    }

    public List<Integer> postOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Object object = stack.pop();
            if (object instanceof TreeNode) {
                TreeNode tempNode = (TreeNode) object;
                //left->right->root
                stack.push(tempNode.val);
                stack.push(tempNode.right);
                stack.push(tempNode.left);
            } else if (object instanceof Integer) {
                list.add((Integer) object);
            }
        }
        return list;
    }
}
