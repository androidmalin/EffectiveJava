package com.example.practice.questiones._true.lc_142_环形链表_入环的第一个节点_hard;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void main() {
        //head = [100,99,0,-100], 输出pos = 1的节点 (99)
        ListNode head = new ListNode(100);
        head.next = new ListNode(99);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-100);
        head.next.next.next.next = head.next;
        Assertions.assertEquals(99, new Solution().detectCycle(head).val);
    }
}
