package com.example.practice.questiones.tree.lc_144_3_二叉树后序遍历_迭代;

public class Problem_05_MorrisTraversal {

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 如果当前cur有左子树
                // 找到cur左子树上最右的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 从上面的while里出来后，mostRight就是cur左子树上最右的节点
                if (mostRight.right == null) { // 如果mostRight.right是指向null的
                    mostRight.right = cur; // 让其指向cur
                    cur = cur.left; // cur向左移动
                    continue; // 回到最外层的while，继续判断cur的情况
                } else { // 如果mostRight.right是指向cur的
                    mostRight.right = null; // 让其指向null
                }
            }
            // cur如果没有左子树，cur向右移动
            // 或者cur左子树上最右节点的右指针是指向cur的，cur向右移动
            cur = cur.right;
        }
    }

    /**
     * 中序遍历
     */
    public static void morrisIn(Node root) {
        if (root == null) return;
        Node cur = root;
        Node mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

//    public static void morrisPre(Node head) {
//        if (head == null) return;
//        Node cur = head;
//        Node mostRight;
//        while (cur != null) {
//            mostRight = cur.left;
//            if (mostRight != null) {
//                while (mostRight.right != null && mostRight.right != cur) {
//                    mostRight = mostRight.right;
//                }
//                if (mostRight.right == null) {
//                    mostRight.right = cur;
//                    System.out.print(cur.value + " ");
//                    cur = cur.left;
//                    continue;
//                } else {
//                    mostRight.right = null;
//                }
//            } else {
//                System.out.print(cur.value + " ");
//            }
//            cur = cur.right;
//        }
//        System.out.println();
//    }

//    public static void morrisPos(Node head) {
//        if (head == null) return;
//        Node cur = head;
//        Node mostRight;
//        while (cur != null) {
//            mostRight = cur.left;
//            if (mostRight != null) {
//                while (mostRight.right != null && mostRight.right != cur) {
//                    mostRight = mostRight.right;
//                }
//                if (mostRight.right == null) {
//                    mostRight.right = cur;
//                    cur = cur.left;
//                    continue;
//                } else {
//                    mostRight.right = null;
//                    printEdge(cur.left);
//                }
//            }
//            cur = cur.right;
//        }
//        printEdge(head);
//        System.out.println();
//    }

//    public static void printEdge(Node head) {
//        Node tail = reverseEdge(head);
//        Node cur = tail;
//        while (cur != null) {
//            System.out.print(cur.value + " ");
//            cur = cur.right;
//        }
//        reverseEdge(tail);
//    }
//
//    public static Node reverseEdge(Node from) {
//        Node pre = null;
//        Node next;
//        while (from != null) {
//            next = from.right;
//            from.right = pre;
//            pre = from;
//            from = next;
//        }
//        return pre;
//    }


    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        morrisIn(head);
        //morrisPre(head);
        //morrisPos(head);
    }
}
