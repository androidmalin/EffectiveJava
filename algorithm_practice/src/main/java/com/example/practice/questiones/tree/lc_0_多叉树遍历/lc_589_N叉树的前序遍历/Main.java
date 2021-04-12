package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_589_N叉树的前序遍历;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        Node root = getNode();
        Solution solution = new Solution();
        List<Integer> resultList = solution.preorder(root);
        System.out.println(resultList);

        List<Integer> resultList2 = solution.preorder_color(root);
        System.out.println(" ");
        System.out.println("preorder2");
        System.out.println(resultList2);

        List<Integer> resultList3 = solution.preorder_stack(root);
        System.out.println(" ");
        System.out.println("preorder3");
        System.out.println(resultList3);
        System.out.println(" ");

    }

    @Test
    public void test() {
        Node root = getNode();
        Solution solution = new Solution();
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        assertEquals(solution.preorder(root), solution.preorder_color(root));
        assertEquals(solution.preorder(root), solution.preorder_stack(root));
        assertEquals(solution.preorder_color(root), solution.preorder_stack(root));

        assertEquals(list, solution.preorder(root));
        assertEquals(list, solution.preorder_color(root));
        assertEquals(list, solution.preorder_stack(root));
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
