package com.example.practice.questiones.lc_116;

public class Test {
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
