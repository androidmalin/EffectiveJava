package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.one;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    /**
     * 利用中序遍历递增的特点
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if (res.size() == 0) return false;
        if (res.size() == 1) return true;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i + 1) <= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        //left -> root -> right
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    @Test
    public void test() {
        //边界测试
        //2147483647-(-2147483648) int越界
        int a = -2147483648;
        int b = 2147483647;
        long result = b - a;
        System.out.println("max:" + (Integer.MAX_VALUE == b));
        System.out.println("max:" + (Integer.MIN_VALUE == a));
        System.out.println("result:" + result);

        TreeNode root = TreeCreateFactory.init(false, -2147483648, null, 2147483647);
        TreeOperation.show(root);
        Solution2 solution2 = new Solution2();
        solution2.inorder(root, new ArrayList<>());
        boolean validBST = solution2.isValidBST(root);
        System.out.println(validBST);
    }

}
