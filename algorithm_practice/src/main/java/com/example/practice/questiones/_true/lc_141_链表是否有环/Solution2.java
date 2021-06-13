package com.example.practice.questiones._true.lc_141_链表是否有环;

import com.example.practice.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * <p>
     * 假设链表的节点数量为n，则该解法的时间复杂度是O(n) 。
     * 由于使用了额外的存储空间，所以算法的空间复杂度同样是O(n) 。
     * website test pass ✅
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            } else {
                visited.add(current);
            }
            current = current.next;
        }
        return false;
    }
}
