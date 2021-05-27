package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution2 {

    /**
     * plugin test pass ✅
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left != null && root.right == null) return 1 + left;
        if (root.right != null && root.left == null) return 1 + right;

        return Math.min(left, right) + 1;
    }

    @Test
    public void main() {
        TreeNode root = TreeCreateFactory.init(false, 1, null, 2, null, null, null, 3);
        TreeOperation.show(root);
        assertEquals(3, new Solution2().minDepth(root));

        TreeNode root1 = TreeCreateFactory.init(false, 1);
        TreeOperation.show(root1);
        assertEquals(1, new Solution2().minDepth(root1));
    }
}
