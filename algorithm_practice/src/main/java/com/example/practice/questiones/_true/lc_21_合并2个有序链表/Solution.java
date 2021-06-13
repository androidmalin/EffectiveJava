package com.example.practice.questiones._true.lc_21_合并2个有序链表;

import com.example.practice.common.ListNode;

public class Solution {
    /**
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
     * <p>
     * 首先，我们设定一个哨兵节点 `dummyHead` ，这可以在最后让我们比较容易地返回合并后的链表。
     * 我们维护一个 `prev` 指针，我们需要做的是调整它的 `next` 指针。
     * 然后，我们重复以下过程，直到 `head1` 或者 `head2` 指向了 `null` ：
     * 如果 `head1` 当前节点的值小于等于 `head2` ，我们就把 `head1` 当前的节点接在 `prev` 节点的后面
     * 同时将 `head1` 指针往后移一位。否则，我们对 `head2` 做同样的操作。
     * <p>
     * 不管我们将哪一个元素接在了后面，我们都需要把 `prev` 向后移一位。
     * <p>
     * 在循环终止的时候， `head1` 和 `head2` 至多有一个是非空的。
     * 由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
     * 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可。
     * <p>
     * 下图展示了 `1->4->5` 和 `1->2->3->6` 两个链表迭代合并的过程：
     */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }
        prev.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }
}
