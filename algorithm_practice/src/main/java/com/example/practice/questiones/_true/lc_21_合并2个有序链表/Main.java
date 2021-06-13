package com.example.practice.questiones._true.lc_21_合并2个有序链表;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void test() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);

        ListNode actualHead = new Solution().mergeTwoLists(head1, head2);
        String actualString = ListNode.get(actualHead);


        ListNode expectedHead = new ListNode(1);
        expectedHead.next = new ListNode(2);
        expectedHead.next.next = new ListNode(3);
        expectedHead.next.next.next = new ListNode(4);
        expectedHead.next.next.next.next = new ListNode(5);
        expectedHead.next.next.next.next.next = new ListNode(6);

        String expectedString = ListNode.get(expectedHead);
        Assertions.assertEquals(expectedString, actualString);
    }
}
