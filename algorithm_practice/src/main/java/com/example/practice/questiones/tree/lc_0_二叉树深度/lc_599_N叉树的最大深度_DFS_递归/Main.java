package com.example.practice.questiones.tree.lc_0_二叉树深度.lc_599_N叉树的最大深度_DFS_递归;

import com.example.practice.common.Node;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    public void test() {
        Node node = new Node(1);
        node.children = new ArrayList<>(3);
        node.children.add(0, new Node(2, new ArrayList<>()));
        node.children.add(1, new Node(3, new ArrayList<>()));
        node.children.add(2, new Node(4, new ArrayList<>()));


        assertEquals(2, new Solution().maxDepth(node));
        assertEquals(2, new Solution2().maxDepth(node));
        assertEquals(2, new Solution3().maxDepth(node));
    }
}
