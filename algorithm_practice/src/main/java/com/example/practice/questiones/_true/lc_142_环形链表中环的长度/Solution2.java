package com.example.practice.questiones._true.lc_142_环形链表中环的长度;

import com.example.practice.common.ListNode;

/**
 * 环形链表中环的长度
 */
public class Solution2 {

    /**
     * 漫画算法小灰的算法之旅.pdf
     *
     *
     * <p>
     * 当两个指针首次相遇，证明链表有环的时候，让两个指针从相遇点继续 循环前进，并统计前进的循环次数，直到两个指针第2次相遇。此时， 统计出来的前进次数就是环长。
     * 因为指针p1每次走1步，指针p2每次走2步，两者的速度差是1步。当两 个指针再次相遇时，p2比p1多走了整整1圈。
     * 因此，环长 = 每一次速度差 × 前进次数 = 前进次数。
     */
    public int getCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int meetCounts = 0;
        int length = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                meetCounts++;
            }
            if (meetCounts == 1) {
                length++;
            }
            if (meetCounts == 2) {
                return length;
            }
        }
        return length;
    }
}
