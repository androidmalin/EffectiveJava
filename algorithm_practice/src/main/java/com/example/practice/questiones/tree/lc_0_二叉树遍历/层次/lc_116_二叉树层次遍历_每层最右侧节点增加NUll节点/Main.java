package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_116_二叉树层次遍历_每层最右侧节点增加NUll节点;

public class Main {
    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = null;
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.next = node.right;
        node.right.next = null;


        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.left.next = node.left.right;

        node.left.right.next = node.right.left;
        node.right.left.next = node.right.right;
        node.right.right.next = null;

        Solution solution = new Solution();
        Node connect = solution.connect(node);
    }
}
