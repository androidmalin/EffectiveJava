package com.example.practice.questiones.tree.lc_94_二叉树_前中后序遍历统一写法_迭代.first_颜色标记法改进版;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3);

        System.out.println(" dg preorder");
        List<Integer> list2 = preOrder(root);
        System.out.println(list2);


        System.out.println(" ");
        System.out.println(" preorder");
        List<Integer> resultList = solution.preOrderTraverse(root);
        System.out.println(resultList);


        System.out.println(" ");
        System.out.println(" inorder");
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);

        System.out.println(" ");
        System.out.println(" postorder");
        List<Integer> list1 = solution.postOrderTraverse(root);
        System.out.println(list1);
    }


    private static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private static void pre(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        pre(root.left, res);
        pre(root.right, res);
    }

}
