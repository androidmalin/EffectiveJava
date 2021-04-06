package com.example.practice.questiones.heap.lc_239_2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;
import com.example.practice.common.TreeOperation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] leastNumbers = solution.maxSlidingWindow(getArray(1, 2, 3, 4), 3);
        System.out.println(" ");
        System.out.println(Arrays.toString(leastNumbers));
    }

    public static int[] getArray(int... integers) {
        return integers;
    }
    @Test
    public void test() {
        Solution solution = new Solution();
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6};
        TreeNode root = TreeCreateFactory.init(Arrays.asList(integers));
        assertFalse(false);
    }
}
