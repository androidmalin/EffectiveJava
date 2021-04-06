package com.example.practice.questiones.tree.lc_0_多叉树遍历.lc_590_N叉树的后序遍历;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        Node root = getNode();
        Solution solution = new Solution();
        List<Integer> postorder = solution.postorder(root);
        System.out.println(postorder);

        List<Integer> postorder2 = solution.postorder2(root);
        System.out.println(postorder2);

        List<Integer> postorder3 = solution.postorder3(root);
        System.out.println(postorder3);

    }

    @Test
    public void test() {
        Node root = getNode();
        Solution solution = new Solution();
        List<Integer> list = Arrays.asList(2, 3, 4, 1);
        assertEquals(solution.postorder(root), solution.postorder2(root));
        assertEquals(solution.postorder(root), solution.postorder3(root));
        assertEquals(list, solution.postorder(root));
        assertEquals(list, solution.postorder2(root));
        assertEquals(list, solution.postorder3(root));
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
