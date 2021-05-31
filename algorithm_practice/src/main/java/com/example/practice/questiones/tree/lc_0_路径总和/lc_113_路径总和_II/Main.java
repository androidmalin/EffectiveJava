package com.example.practice.questiones.tree.lc_0_路径总和.lc_113_路径总和_II;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/114437204
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 */
public class Main {

    @Test
    public void main() {
        TreeNode root = TreeCreateFactory.init(false,
                5, 4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, null, 5, 1
        );
        //TreeOperation.show(root);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 22);
        System.out.println(lists);

        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList(5, 4, 11, 2)));
        expectedList.add(new ArrayList<>(Arrays.asList(5, 8, 4, 5)));
        Assertions.assertEquals(expectedList, lists);
    }


    @Test
    public void main1() {
        TreeNode root = TreeCreateFactory.init(false,
                1, 2, 5,
                3, null, null, null
        );
        //TreeOperation.show(root);
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 6);
        System.out.println(lists);

        List<List<Integer>> expectedList = new ArrayList<>();
        expectedList.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        expectedList.add(new ArrayList<>(Arrays.asList(1, 5)));
        Assertions.assertEquals(expectedList, lists);
    }
}
