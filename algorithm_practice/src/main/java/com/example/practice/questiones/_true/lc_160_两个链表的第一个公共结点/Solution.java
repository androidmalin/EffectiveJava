package com.example.practice.questiones._true.lc_160_两个链表的第一个公共结点;

import com.example.practice.common.ListNode;

/**
 * 160. 相交链表
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 编写一个程序，找到两个单链表相交的起始节点。
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class Solution {
    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/353116
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
