package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.lc_102_二叉树的层序遍历_递归;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 实现:递归实现
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * pass
 */
public class Solution {


    /**
     * 递归实现 层次遍历
     * 深度优先遍历.
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 1, root);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int index, TreeNode root) {
        if (root == null) return;
        //假设res是[ [1],[2,3] ], index是3,就再插入一个空list放到res中
        if (res.size() < index) res.add(new ArrayList<>());

        //将当前节点的值加入到res中,index代表当前层,假设index是3,节点值是99
        //res是[ [1],[2,3] [4] ],加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index - 1).add(root.val);

        //递归的处理左子树,右子树,同时将层数index+1
        dfs(res, index + 1, root.left);
        dfs(res, index + 1, root.right);
    }
}
