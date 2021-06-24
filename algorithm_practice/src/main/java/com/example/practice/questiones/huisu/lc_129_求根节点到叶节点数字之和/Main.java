package com.example.practice.questiones.huisu.lc_129_求根节点到叶节点数字之和;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3);
        TreeOperation.show(root);
        Assertions.assertEquals(25, new Solution().sumNumbers(root));
        Assertions.assertEquals(25, new Solution2().sumNumbers(root));
        Assertions.assertEquals(25, new Solution_BFS().sumNumbers(root));
    }
}
