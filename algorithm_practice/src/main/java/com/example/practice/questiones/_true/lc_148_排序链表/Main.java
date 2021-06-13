package com.example.practice.questiones._true.lc_148_排序链表;

import com.example.practice.common.ListNode;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);

        System.out.println(head);
        ListNode listNode = new Solution().sortList(head);

        System.out.println(listNode.val);

        System.out.println(listNode);
        System.out.println(" ");
    }

}
