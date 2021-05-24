package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;

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