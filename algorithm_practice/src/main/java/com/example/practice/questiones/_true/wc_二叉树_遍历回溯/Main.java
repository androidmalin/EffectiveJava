package com.example.practice.questiones._true.wc_二叉树_遍历回溯;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        TreeOperation.show(root);
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), Arrays.asList(1, 2, 3, 2, 1)));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().pre(root), Arrays.asList(1, 2, 3, 2, 1)));
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), new Solution2().pre(root)));
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeOperation.show(root);
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), Arrays.asList(1, 2, 1, 3, 1)));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().pre(root), Arrays.asList(1, 2, 1, 3, 1)));
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), new Solution2().pre(root)));
    }


    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3,
                4, 5, 6, 7,
                8, 9, 10, 11, 12, 13, 14, 15
        );
        TreeOperation.show(root);
        List<Integer> list1 = Arrays.asList(1, 2, 4, 8, 4, 9, 4, 2, 5, 10, 5, 11, 5, 2, 1, 3, 6, 12, 6, 13, 6, 3, 7, 14, 7, 15, 7, 3, 1);
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), list1));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().pre(root), list1));
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), new Solution2().pre(root)));

    }

    /**
     * ````````````````````````
     * ````````````1```````````
     * `````````/`````\````````
     * ``````2```````````3`````
     * ````/```\```````/```\```
     * ``4``````n````n```````7`
     * ````````````````````````
     * <p>
     * 1, 2, 4, 2, 1, 3, 7, 3, 1
     */
    @Test
    public void test3() {
        TreeNode root = TreeCreateFactory.init(false,
                1, 2, 3,
                4, null, null, 7
        );
        TreeOperation.show(root);
        List<Integer> list1 = Arrays.asList(1, 2, 4, 2, 1, 3, 7, 3, 1);
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), list1));
        Assertions.assertTrue(ListUtil.isSame(new Solution2().pre(root), list1));
        Assertions.assertTrue(ListUtil.isSame(new Solution().pre(root), new Solution2().pre(root)));
    }

    @Test
    public void test4() {
        TreeNode root = TreeCreateFactory.init(false,
                1, 2, 3
        );
        TreeOperation.show(root);
    }
}
