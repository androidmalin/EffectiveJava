package com.example.practice.common;


/**
 * https://github.com/billvanyo/tree_printer
 */
public class TreeOperation {

    public static void show(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("this is empty tree");
        }
        TreePrinter<TreeNode> printer = new TreePrinter<>(n -> nameForNumber(n.val), n -> n.left, n -> n.right);
        // set minimum horizontal spacing between node labels with setHSpace
        printer.sethSpace(2);
        // use square branches
        printer.setSquareBranches(false);
        printer.printTree(root);
        System.out.println();
    }

    private static String nameForNumber(int n) {
        return String.valueOf(n);
    }

    public static void main(String[] args) {
        // 根据给定的数组创建一棵树
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);
    }
}
