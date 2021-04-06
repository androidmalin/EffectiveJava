package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_116_二叉树层次遍历_每层最右侧节点增加NUll节点;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}