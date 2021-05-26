package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.bfs.one;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution {
    /**
     * 利用中序遍历递增的特点
     * website test pass ✅
     */
    public boolean isValidBST(TreeNode root) {
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

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, -2147483648, null, 2147483647);
        TreeOperation.show(root);
        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);
    }
}
