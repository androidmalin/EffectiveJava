package com.example.practice.questiones.tree.lc_0_二叉树遍历.层次.jian_32_III;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    @Test
    public void test() {
        //给定二叉树 [3,9,20,null,null,15,7],
        //输出:
        //[
        //  [3],
        //  [20,9],
        //  [15,7]
        //]
        TreeNode root = TreeCreateFactory.init(3, 9, 20, null, null, 15, 7);
        TreeOperation.show(root);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);

        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(3));
        list.add(Arrays.asList(20, 9));
        list.add(Arrays.asList(15, 7));
        Assertions.assertEquals(list, lists);
    }
}
