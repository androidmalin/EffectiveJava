package com.example.practice.questiones._true.lc_141_链表是否有环;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        Assertions.assertFalse(new Solution().hasCycle(head));
        Assertions.assertFalse(new Solution2().hasCycle(head));
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Assertions.assertFalse(new Solution().hasCycle(head));
        Assertions.assertFalse(new Solution2().hasCycle(head));
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next.next;
        Assertions.assertTrue(new Solution().hasCycle(head));
        Assertions.assertTrue(new Solution2().hasCycle(head));
    }

}
