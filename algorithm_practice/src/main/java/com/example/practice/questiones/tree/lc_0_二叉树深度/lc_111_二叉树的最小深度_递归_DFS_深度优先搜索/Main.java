package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_111_二叉树的最小深度_递归_DFS_深度优先搜索;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(false, 1, null, 2, null, null, null, 3);
        TreeOperation.show(root);
        assertEquals(3, new Solution().minDepth(root));
        assertEquals(3, new Solution2().minDepth(root));
        assertEquals(3, new Solution3().minDepth(root));
        assertEquals(3, new Solution_M2().minDepth(root));
    }

    @Test
    public void main() {
        TreeNode root = TreeCreateFactory.init(false, 1);
        TreeOperation.show(root);
        assertEquals(1, new Solution().minDepth(root));
        assertEquals(1, new Solution2().minDepth(root));
        assertEquals(1, new Solution3().minDepth(root));
        assertEquals(1, new Solution_M2().minDepth(root));
    }
}
