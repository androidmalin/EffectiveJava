package com.example.practice.questiones._true.lc_141_链表是否有环;

import com.example.practice.common.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution {

    /**
     * 假设链表的节点数量为n，则该算法的时间复杂度为O(n)。
     * 除两个指针外，没有使用任何额外的存储空间，所以空间复杂度是O(1)。
     * <p>
     * website test pass ✅
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
