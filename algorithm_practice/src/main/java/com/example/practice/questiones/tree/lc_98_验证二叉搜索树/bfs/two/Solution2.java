package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.two;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    /**
     * 5.26✅
     * plugin test pass
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= pre) return false;
            pre = temp.val;
            currentNode = temp.right;
        }
        return true;
    }


    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(false, -2147483648, null, 2147483647);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        List<Integer> list = solution2.inorder(root);
        System.out.println(list);
        boolean validBST = solution2.isValidBST(root);
        System.out.println(validBST);
    }

    public List<Integer> inorder(TreeNode root) {
        //left ->root ->right
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            current = temp.right;
        }
        return res;
    }
}
