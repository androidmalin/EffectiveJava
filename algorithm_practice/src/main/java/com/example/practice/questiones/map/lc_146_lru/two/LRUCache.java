package com.example.practice.questiones.map.lc_146_lru.two;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * 题解:
 * <p>
 * 这道题要求设计实现LRU cache的数据结构，实现set和get功能。
 * 学习过操作系统的都应该知道，cache作为缓存可以帮助快速存取数据，但是确定是容量较小。
 * 这道题要求实现的cache类型是LRU，LRU的基本思想就是"最近用到的数据被重用的概率比较早用到的大的多"，
 * 是一种更加高效的cache类型。
 * <p>
 * 解决这道题的方法是: 双向链表+HashMap。
 * <p>
 * "为了能够快速删除最久没有访问的数据项和插入最新的数据项，我们将双向链表连接Cache中的数据项，
 * 并且保证链表维持数据项从最近访问到最旧访问的顺序。
 * 每次数据项被查询到时，都将此数据项移动到链表头部（O(1)的时间复杂度）。
 * 这样，在进行过多次查找操作后，最近被使用过的内容就向链表的头移动，
 * 而没有被使用的内容就向链表的后面移动。
 * 当需要替换时，链表最后的位置就是最近最少被使用的数据项，
 * 我们只需要将最新的数据项放在链表头部，当Cache满 时，淘汰链表最后的位置就是了。 "
 * <p>
 * "注:  对于双向链表的使用，基于两个考虑。
 * 首先是Cache中块的命中可能是随机的，和Load进来的顺序无关。
 * <p>
 * 其次，双向链表插入、删除很快，可以灵活的调整相互间的次序，时间复杂度为O(1)。"
 * <p>
 * 解决了LRU的特性，现在考虑下算法的时间复杂度。
 * 为了能减少整个数据结构的时间复杂度，就要减少查找的时间复杂度，所以这里利用HashMap来做，
 * 这样时间就是O(1)。
 * <p>
 * 所以对于本题来说:
 * <p>
 * get(key): 如果cache中不存在要get的值，返回-1；
 * 如果cache中存在要找的值，返回其值并将其在原链表中删除，然后将其作为头结点。
 * <p>
 * set(key,value): 当要set的key值已经存在，就更新其value，将其在原链表中删除，然后将其作为头结点；
 * 当要set的key值不存在，就新建一个node，
 * 如果当前length < capacity,就将其加入hashMap中，并将其作为头结点，更新length长度，
 * 否则，删除链表最后一个node，再将其放入hashMap并作为头结点，但length不更新。
 */
public class LRUCache {

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            //stack prev
            Stack<String> stack = new Stack<>();
            while (prev != null) {
                stack.push("<=prev===>" + "[" + prev.value + "]");
                prev = prev.prev;
            }

            //prev
            StringBuilder result = new StringBuilder("null");
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            result.append("<=prev===").append("『").append(value).append("』").append("===next=>");
            while (next != null) {
                result.append("[").append(next.value).append("]").append("<===next=>");
                next = next.next;
            }
            result.append("null");
            return result.toString();
        }
    }


    public static class Solution {
        @Test
        public void test0() {

        }
    }

}
