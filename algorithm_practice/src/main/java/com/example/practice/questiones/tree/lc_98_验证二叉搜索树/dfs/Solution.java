package com.example.practice.questiones.tree.lc_98_验证二叉搜索树.dfs;

import com.example.practice.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution {
    /**
     * ``````10`````
     * ````/```\````
     * ``8```````11`
     * `/`\`````````
     * 4```9````````
     * <p>
     * website test pass ✅
     * <p>
     * 要解决这道题首先我们要了解二叉搜索树有什么性质可以给我们利用，由题目给出的信息我们可以知道：
     * **如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，
     * 则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。**
     * <p>
     * 这启示我们设计一个递归函数 `helper(root, lower, upper)` 来递归判断，函数表示考虑以 `root` 为根的子树，
     * 判断子树中所有节点的值是否都在 *(l,r)* 的范围内（**注意是开区间**）。
     * 如果 `root` 节点的值 `val` 不在 *(l,r)* 的范围内说明不满足条件直接返回，否则我们要继续递归调用检查它的左右子树是否满足，
     * 如果都满足才说明这是一棵二叉搜索树。
     * <p>
     * 那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 `upper` 改为 `root.val`，
     * 即调用 `helper(root.left, lower, root.val)`，因为左子树里所有节点的值均小于它的根节点的值。
     * 同理递归调用右子树时，我们需要把下界 `lower` 改为 `root.val`，即调用 `helper(root.right, root.val, upper)`。
     * <p>
     * 函数递归调用的入口为 `helper(root, -inf, +inf)`， `inf` 表示一个无穷大的值。
     */
    public boolean isValidBST(TreeNode root) {
        //1.left => (-∞, 最大值(上界))
        //2.right => (最少值(下界), +∞)
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        boolean left = isValidBST(root.left, lower, root.val);
        boolean right = isValidBST(root.right, root.val, upper);
        return left && right;
    }

}