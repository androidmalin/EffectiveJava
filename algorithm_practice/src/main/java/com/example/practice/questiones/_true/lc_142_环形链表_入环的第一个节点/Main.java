package com.example.practice.questiones._true.lc_142_环形链表_入环的第一个节点;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void main() {
        //head = [1,2,3,4], 输出pos = 1的节点 (2)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(head);
        ListNode.printCycleListNode(head,2);
        Assertions.assertEquals(2, listNode.val);
    }

}
