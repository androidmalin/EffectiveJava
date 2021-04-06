package com.example.practice.questiones.tree.lc_100_相同的树;

import com.example.practice.common.TreeNode;


/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Solution {

    /**
     * 分情况讨论, 使用递归
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1.p==null && q==null
        if (p == null && q == null) return true;

        //2.p!=null && q==null
        if (p != null && q == null) return false;

        //3.p==null && q!=null
        if (p == null && q != null) return false;

        //4.p!=null && q!=null
        //root
        if (p.val != q.val) return false;
        //left
        boolean left = isSameTree(p.left, q.left);
        //right
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}
