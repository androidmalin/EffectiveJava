package com.example.practice.questiones.tree.lc_0_二叉树遍历.中序.lc_94_二叉树中序遍历_迭代;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 144. 二叉树的中序遍历
 * 实现:非递归
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(1, 2, 3, null, 5, 6, 7);

        List<Integer> list = solution.inorderTraversal(root);
        System.out.println("迭代--二叉树的中序遍历:");
        System.out.println(list);

        System.out.println("递归--二叉树的中序遍历:");
        List<Integer> list1 = TreeUtil.inOrder(root);
        System.out.println(list1);


        System.out.println(" review 0 ");
        List<Integer> list2 = solution.inorderTraversal_ReView0(root);
        System.out.println(list2);

        System.out.println(" review 1 ");
        List<Integer> list3 = solution.inorderTraversal_ReView1(root);
        System.out.println(list3);

        System.out.println(" review 2 ");
        List<Integer> list4 = solution.inorderTraversal_ReView2(root);
        System.out.println(list4);

        System.out.println(" review 3 ");
        List<Integer> list5 = solution.inorderTraversal_ReView3(root);
        System.out.println(list5);

        List<Integer> list6 = new Solution().inorderTraversal_ReView4(root);
        System.out.println(" review 4 ");
        System.out.println(list6);
    }

    @Test
    public void test() {
        TreeNode root = TreeUtil.getTreeNode();
        Solution solution = new Solution();
        TreeOperation.show(root);
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal_ReView0(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal_ReView1(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal_ReView2(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal_ReView3(root));
        assertEquals(TreeUtil.inOrder(root), solution.inorderTraversal_ReView4(root));
    }
}
