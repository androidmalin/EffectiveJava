package com.example.practice.questiones._true.lc_142_环形链表中环的长度;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = head.next.next.next;
        Assertions.assertEquals(4, new Solution().getCycleLength(head));
        Assertions.assertEquals(4, new Solution2().getCycleLength(head));
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Assertions.assertEquals(0, new Solution().getCycleLength(head));
        Assertions.assertEquals(0, new Solution2().getCycleLength(head));
    }
}
