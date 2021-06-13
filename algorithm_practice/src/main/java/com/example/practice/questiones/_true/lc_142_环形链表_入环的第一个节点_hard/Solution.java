package com.example.practice.questiones._true.lc_142_环形链表_入环的第一个节点_hard;

import com.example.practice.common.ListNode;

/**
 * https://blog.nowcoder.net/n/c42a259697014745b1688f9c6795d206?f=comment
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 */
public class Solution {

    /**
     * <p>
     * <<漫画算法小灰的算法之旅.pdf
     * <p>
     * 上图是对有环链表所做的一个抽象示意图。
     * 假设从链表头节点到入环点的距离是D，从入环点到两个指针首次相遇点的距离是S1 ，
     * 从首次相遇点回到入环点的距离是S2。
     * 那么，当两个指针首次相遇时，各自所走的距离是多少呢?
     * 指针p1一次只走1步，所走的距离是D+S1。
     * 指针p2一次走2步，多走了n(n>=1)整圈，所走的距离是D+S1 +n(S1 +S2)。
     * <p>
     * 由于p2的速度是p1的2倍，所以所走距离也是p1的2倍，因此:
     * 2(D+S1) = D+S1 +n(S1 +S2)
     * 2D+2S1 = D+S1 + nS1+nS2
     * D = nS1 + nS2 - S1
     * D = (n-1)(S1 +S2)+S2
     * D = nS1 + nS2 - S1 -S2 +S2 = nS1 + nS2 - S1 = (n-1)(S1 +S2)+S2
     * <p>
     * 等式经过整理得出:
     * D = (n-1)(S1 +S2)+S2
     * <p>
     * 也就是说，从链表头结点到入环点的距离，等于从首次相遇点绕环n-1圈再回到入环点的距离。
     * 这样一来，只要把其中一个指针放回到头节点位置，另一个指针保持在 首次相遇点，
     * 两个指针都是每次向前走1步。那么，它们最终相遇的节点，就是入环节点。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
