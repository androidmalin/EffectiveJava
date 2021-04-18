package com.example.practice.questiones.tree.lc_100_相同的树.dfs;

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
     * 深度优先搜索
     * 如果两个二叉树都为空，则两个二叉树相同。
     * 如果两个二叉树中有且只有一个为空，则两个二叉树一定不相同。
     * <p>
     * 如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，若不相同则两个二叉树一定不同，
     * 若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。
     * 这是一个递归的过程，因此可以使用深度优先搜索，递归地判断两个二叉树是否相同。
     * <p>
     * https://leetcode-cn.com/problems/same-tree/solution/xiang-tong-de-shu-by-leetcode-solution/
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1.递归终止条件.

        //① p==null && q==null
        //```N```
        //```````
        //```````
        //
        //```N```
        //```````
        //```````

        //② p==null && q!=null
        //```N```
        //```````
        //```````
        //
        //```1```
        //```````
        //```````

        //③ p!=null && q==null
        //```1```
        //```````
        //```````
        //
        //```N```
        //```````
        //```````

        //④ p!=null && q!=null && p.val!=q.val
        //```1```
        //```````
        //```````
        //
        //```2```
        //```````
        //```````


        //⑤
        //`````````1``````````
        //````````/`\`````````
        //`(left)2```3(right)`

        //`````````1``````````
        //````````/`\`````````
        //`(left)2```3(right)`

        //① p==null && q==null
        if (p == null && q == null) return true;

        //② p==null && q!=null
        if (p == null && q != null) return false;

        //③ p!=null && q==null
        if (p != null && q == null) return false;

        //④ p!=null && q!=null && p.val!=q.val
        if (p.val != q.val) return false;

        //2.最小重复子问题.
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        //3.返回值
        return left && right;
    }


}
