package com.example.practice.questiones._true.lc_21_合并2个有序链表;

import com.example.practice.common.ListNode;

public class Solution2 {

    /**
     * 两个链表头部值较小的一个节点与剩下元素的 `merge` 操作结果合并。
     * <p>
     * 如果 `head1` 或者 `head2` 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
     * 否则，我们要判断 `head1` 和 `head2` 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
     * 如果两个链表有一个为空，递归结束。
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }
}
