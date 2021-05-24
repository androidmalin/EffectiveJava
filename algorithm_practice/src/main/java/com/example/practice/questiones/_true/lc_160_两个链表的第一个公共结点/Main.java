package com.example.practice.questiones._true.lc_160_两个链表的第一个公共结点;

import com.example.practice.common.ListNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {

    @Test
    public void main() {

        //8,4,5
        ListNode sameHead = new ListNode(8);
        sameHead.next = new ListNode(4);
        sameHead.next.next = new ListNode(5);

        //listA = [4,1,8,4,5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = sameHead;

        //listB = [5,0,1,8,4,5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = sameHead;

        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
        Assertions.assertEquals(8, intersectionNode.val);
    }
}
