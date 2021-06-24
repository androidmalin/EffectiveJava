package com.example.practice.questiones.tree.lc_0_翻转二叉树.lc_226_翻转二叉树_递归_DFS_后序;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        Assertions.assertTrue(TreeUtil.isSameTree(new Solution().invertTree(TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7)), TreeCreateFactory.init(1, 3, 2, 7, 6, 5, 4)));
        Assertions.assertTrue(TreeUtil.isSameTree(new Solution2().invertTree(TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7)), TreeCreateFactory.init(1, 3, 2, 7, 6, 5, 4)));
    }
}
