package com.example.practice.review.max;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6);
        TreeOperation.show(root);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = TreeCreateFactory.init(integers);
        assertFalse(false);
    }
}
