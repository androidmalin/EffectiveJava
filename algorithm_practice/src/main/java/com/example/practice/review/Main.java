package com.example.practice.review;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        List<List<Integer>> level = solution.level(root);
        System.out.println(level);


//        System.out.println("pre");
//        List<Integer> pre = solution.preOrder(root);
//        System.out.println(pre);

//        System.out.println("ino");
//        List<Integer> list = solution.inOrder(root);
//        System.out.println(list);
//
//        System.out.println("post");
//        List<Integer> list1 = solution.postOrder(root);
//        System.out.println(list1);
//
//        System.out.println("post2");
//        List<Integer> list2 = solution.postOrder_(root);
//        System.out.println(list2);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));
        assertFalse(false);
    }
}
