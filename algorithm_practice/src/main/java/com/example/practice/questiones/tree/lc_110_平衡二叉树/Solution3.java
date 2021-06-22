package com.example.practice.questiones.tree.lc_110_平衡二叉树;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * <p>
 */
public class Solution3 {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(3, 9, 20, null, null, 15, 7);
        TreeOperation.show(root);
        Solution3 solution3 = new Solution3();
        boolean balanced = solution3.isBalanced(root);
        System.out.println(balanced);
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, 2, 2, 3, 3, null, null, 4, 4);
        TreeOperation.show(root);
        Solution3 solution3 = new Solution3();
        boolean balanced = solution3.isBalanced(root);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean abs = Math.abs(height(root.left) - height(root.right)) <= 1;
        return abs && isBalanced(root.left) && isBalanced(root.right);
    }


    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
