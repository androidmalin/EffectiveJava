package com.example.practice.questiones.tree.lc_0_二叉树遍历.统一写法.first_颜色标记法改进版;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3);

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


    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        assertEquals(solution.preOrder(root), solution.preOrderTraverse(root));
        assertEquals(solution.inOrder(root), solution.inorderTraversal(root));
        assertEquals(solution.postOrder(root), solution.postOrderTraverse(root));
    }

}
