package com.example.practice.questiones.tree.lc_94_二叉树的中序遍历;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import java.util.List;

public class Test {
    /**
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     */
    public static void main(String[] args) {

        //注意:这里使用的数组和官网不一致, 但是生成的二叉树形状是一致的.
        TreeNode root = TreeCreateFactory.init(1, null, 2, null, null, 3, null);
        Solution solution = new Solution();
        List<Integer> list = solution.inorderTraversal(root);
        System.out.println(list);
    }
}
