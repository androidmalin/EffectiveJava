package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.review;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {


    public static void main(String[] args) {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, null, null);
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
    }


    @Test
    public void test_0() {
        TreeNode root = null;
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
        Assertions.assertTrue(completeTree);
    }

    /**
     * true
     * <p>
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````````
     * 4```5````````
     */
    @Test
    public void test0() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, null, null);
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
        Assertions.assertTrue(completeTree);
    }

    /**
     * ``````1```````
     * ````/```\`````
     * ``N```````3```
     * `/`\`````/`\``
     * 4```5```6```7`
     */
    @Test
    public void test1() {
        TreeNode root = TreeCreateFactory.init(1, null, 3, 4, 5, 6, 7);
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
        Assertions.assertFalse(completeTree);
    }


    /**
     * ``````1```````
     * ````/```\`````
     * ``2```````3```
     * `/`\`````/`\``
     * N```N```6```7`
     */
    @Test
    public void test2() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, null, null, 6, 7);
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
        Assertions.assertFalse(completeTree);
    }


    /**
     * True
     * ``````1``````
     * ````/```\````
     * ``2```````3``
     * `/`\`````/```
     * 4```5```6````
     */
    @Test
    public void test3() {
        TreeNode root = TreeCreateFactory.init(1, 2, 3, 4, 5, 6, null);
        Solution solution = new Solution();
        boolean completeTree = solution.isCompleteTree(root);
        System.out.println("completeTree:" + completeTree);
        Assertions.assertTrue(completeTree);
    }
}