package com.example.practice.questiones._true.lc_148_排序链表;

import com.example.practice.common.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
 */
public class Solution {

    /**
     * 方法一：自顶向下归并排序
     * 对链表自顶向下归并排序的过程如下。
     * <p>
     * 找到链表的中点，以中点为分界，将链表拆分成两个子链表。
     * 寻找链表的中点可以使用快慢指针的做法，快指针每次移动 2 步，慢指针每次移动 1 步，
     * 当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
     * <p>
     * 对两个子链表分别排序。
     * <p>
     * 将两个排序后的子链表合并，得到完整的排序后的链表。
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }


    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }

}
