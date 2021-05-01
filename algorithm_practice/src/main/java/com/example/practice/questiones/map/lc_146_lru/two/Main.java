package com.example.practice.questiones.map.lc_146_lru.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public static void main(String[] args) {
        LRUCache.DLinkedNode node1 = new LRUCache.DLinkedNode(1, 1);
        LRUCache.DLinkedNode node2 = new LRUCache.DLinkedNode(2, 2);
        LRUCache.DLinkedNode node3 = new LRUCache.DLinkedNode(3, 3);
        LRUCache.DLinkedNode node4 = new LRUCache.DLinkedNode(4, 4);
        LRUCache.DLinkedNode node5 = new LRUCache.DLinkedNode(5, 5);
        LRUCache.DLinkedNode node6 = new LRUCache.DLinkedNode(6, 6);
        node1.prev = null;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;
        System.out.println(node3);
    }

    @Test
    public void test() {

        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);


        int i = cache.get(1);// 返回  1
        Assertions.assertEquals(1, i);
        cache.put(3, 3); // 该操作会使得密钥 2 作废

        int i1 = cache.get(2);// 返回 -1 (未找到)
        Assertions.assertEquals(-1, i1);
        cache.put(4, 4); // 该操作会使得密钥 1 作废

        int i2 = cache.get(1);// 返回 -1 (未找到)
        Assertions.assertEquals(-1, i2);

        int i3 = cache.get(3);// 返回  3
        Assertions.assertEquals(3, i3);

        int i4 = cache.get(4);// 返回  4
        Assertions.assertEquals(4, i4);
    }
}
