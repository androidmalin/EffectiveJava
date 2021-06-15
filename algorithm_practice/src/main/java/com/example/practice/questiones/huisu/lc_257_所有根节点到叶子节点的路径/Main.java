package com.example.practice.questiones.huisu.lc_257_所有根节点到叶子节点的路径;

import com.example.practice.common.ListUtil;
import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Main {

    @Test
    public void test() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        TreeOperation.show(root);
        List<String> actualList = new Solution().binaryTreePaths(root);
        System.out.println(actualList);

        List<String> expectedList = Arrays.asList("1->2->4", "1->2->5", "1->3->6", "1->3->7");
        Assertions.assertTrue(ListUtil.isSame(expectedList, actualList));
    }

    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        TreeOperation.show(root);
        List<String> actualList = new Solution_2().binaryTreePaths(root);
        System.out.println(actualList);

        List<String> expectedList = Arrays.asList("1->2->4", "1->2->5", "1->3->6", "1->3->7");
        Assertions.assertTrue(ListUtil.isSame(expectedList, actualList));
    }
}
