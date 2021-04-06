package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_559_N叉树的最大深度_BFS_迭代;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}