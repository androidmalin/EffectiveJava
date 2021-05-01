package com.example.practice.questiones.map.lc_146_lru;

import com.example.practice.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public void print(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                System.out.println(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                size--;
            }

        }
    }

    public void print2(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                size--;
            }
        }
    }

    public void print3(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.right);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);

                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.left != null) queue.offer(tempNode.left);

            }
        }
    }

    public void fun(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                System.out.println(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                size--;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                System.out.println(temp.val);
                System.out.println(temp.val);
                System.out.println(temp.val);
                System.out.println(temp.val);
                System.out.println(temp.val);
                System.out.println(temp.val);
            }
        }
    }

    //1.loop,message,handler
    //2.java design pattern
    //3.s
    public boolean isBinary(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode tmp = stack.pop();
            if (tmp.val <= pre) return false;
            currentNode = tmp.right;
        }
        return true;
    }

    public boolean isBinary2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reach = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    reach = true;
                } else {
                    if (reach) {
                        if (temp != null) return false;
                    }
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
                size--;
            }
        }
        return true;
    }
}
