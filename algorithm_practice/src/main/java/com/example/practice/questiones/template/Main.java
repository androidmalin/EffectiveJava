package com.example.practice.questiones.template;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6);
        TreeOperation.show(root);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = TreeCreateFactory.init(false, 1, 2, 3, 4, 5, 6);
        TreeOperation.show(root);
        assertFalse(false);
        assertTrue(true);
    }
}
