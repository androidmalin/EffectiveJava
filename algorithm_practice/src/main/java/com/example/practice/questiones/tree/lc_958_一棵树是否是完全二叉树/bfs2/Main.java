package com.example.practice.questiones.tree.lc_958_一棵树是否是完全二叉树.bfs2;

import com.example.practice.common.TreeCreateFactory;
import com.example.practice.common.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    /**
     * true
     * <p>
     * ``````null``````
     */
    @Test
    public void test() {
        TreeNode root = null;
        Assertions.assertTrue(new Solution().isCompleteTree(root));
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
        Assertions.assertTrue(new Solution().isCompleteTree(root));
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
        Assertions.assertFalse(new Solution().isCompleteTree(root));
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
        Assertions.assertFalse(new Solution().isCompleteTree(root));
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
        Assertions.assertTrue(new Solution().isCompleteTree(root));
    }
}
