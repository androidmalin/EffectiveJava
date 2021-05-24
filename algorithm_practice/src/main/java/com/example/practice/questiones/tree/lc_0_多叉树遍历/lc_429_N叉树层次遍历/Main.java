package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_429_N叉树层次遍历;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void test() {
        Node root = getNode();
        Solution solution = new Solution();

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Collections.singletonList(1));
        resultList.add(Arrays.asList(2, 3, 4));

        assertEquals(resultList, solution.levelOrder(root));
    }

    /**
     * ````1`````
     * `/``|``\``
     * 2```3```4`
     * ``````````
     */
    private static Node getNode() {
        Node node = new Node(1);
        node.children = new ArrayList<>(3);
        node.children.add(0, new Node(2));
        node.children.add(1, new Node(3));
        node.children.add(2, new Node(4));
        return node;
    }
}
