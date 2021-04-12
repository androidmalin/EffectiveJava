package com.example.practice.questiones.tree.lc_0_二叉树遍历.前序.lc_144_二叉树前序遍历_递归;

import com.example.practice.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 实现:递归
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {


    /**
     * 前序遍历:
     * 实现:递归
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     * <p>
     * 首先我们需要了解什么是二叉树的前序遍历:
     * 按照访问  根节点-->左子树-->右子树  的方式遍历这棵树，而在访问左子树或者右子树的时候，我们按照同样的方式遍历，直到遍历完整棵树。
     * 因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。
     * <p>
     * 定义 preorder(root) 表示当前遍历到 root 节点的答案。
     * 按照定义，我们只要首先将 root 节点的值加入答案，然后递归调用 preorder(root.left) 来遍历 root 节点的左子树，
     * 最后递归调用 preorder(root.right) 来遍历 root 节点的右子树即可，递归终止的条件为碰到空节点。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度： O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
     * <p>
     * 空间复杂度： O(n)，为递归过程中栈的开销，平均情况下为 O(log n)，最坏情况下树呈现链状，为 O(n)。
     * 平均的情况为满二叉树,如下图所示:
     * <p>
     * ```````````````高度    节点个数
     * ``````1`````````1        1
     * ````/```\```````
     * ``2```````3`````2        3
     * `/`\`````/`\````
     * 4```5```6```7```3        7
     * 高度定义为h, 节点数定义为N的话, 他们之间的关系是
     * 2^h - 1 = N
     * h = log2(N+1)
     * 忽略常数的话, h = logN
     * <p>
     * 最坏情况下树呈现链状,二叉树退化为链表,如下所示:
     * <p>
     * ``````1```````
     * ````````\`````
     * ``````````3```
     * ```````````\``
     * ````````````7`
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    /**
     * 可视化演示
     * https://alchemist-al.com/algorithms/binary-tree-preorder-traversal
     */
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
