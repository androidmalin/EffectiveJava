package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_590_N叉树的后序遍历;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {


    @Test
    public void test() {
        Node root = getNode();
        Solution solution = new Solution();
        List<Integer> list = Arrays.asList(2, 3, 4, 1);

        assertEquals(solution.postorder(root), solution.postorder_color(root));
        assertEquals(solution.postorder(root), solution.postorder_two_stack(root));
        assertEquals(solution.postorder_color(root), solution.postorder_two_stack(root));

        assertEquals(list, solution.postorder(root));
        assertEquals(list, solution.postorder_color(root));
        assertEquals(list, solution.postorder_two_stack(root));
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
