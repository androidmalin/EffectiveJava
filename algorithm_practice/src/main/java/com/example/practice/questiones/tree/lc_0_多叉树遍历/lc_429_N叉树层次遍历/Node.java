package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_429_N叉树层次遍历;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}