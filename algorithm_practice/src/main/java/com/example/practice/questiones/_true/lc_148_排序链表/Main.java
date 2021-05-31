package com.example.practice.questiones._true.lc_148_排序链表;

import com.example.practice.common.ListNode;

public class Main {

    public static void main(String[] args) {
        //head = [100,99,0,-100], 输出pos = 1的节点 (99)
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        Solution solution = new Solution();

        System.out.println(getListNode(head));
        ListNode listNode = solution.sortList(head);

        System.out.println(listNode.val);

        System.out.println(getListNode(listNode));
        System.out.println(" ");
    }

    private static String getListNode(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode current = head;
        if (current == null) return "null";
        while (current != null) {
            stringBuilder.append(current.val);
            stringBuilder.append("==>");
            current = current.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

}
