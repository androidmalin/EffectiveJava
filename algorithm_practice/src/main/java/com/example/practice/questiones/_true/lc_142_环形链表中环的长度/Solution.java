package com.example.practice.questiones._true.lc_142_环形链表中环的长度;

import com.example.practice.common.ListNode;

/**
 * https://blog.csdn.net/inspiredbh/article/details/54915091
 */
public class Solution {

    public int getCycleLength(ListNode head) {
        ListNode node = cycleListNode(head);
        //ListNode为空则代表链表无环
        if (node == null) return 0;
        int length = 1;
        ListNode current = node.next;
        //再次相遇则循环结束
        while (current != node) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 求环中相遇结点
     */
    public ListNode cycleListNode(ListNode head) {
        //链表为空则返回null
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //两指针相遇，则返回相遇的结点 
            if (fast == slow) return fast;
        }
        //链表无环，则返回null
        return null;
    }
}
