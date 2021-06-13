package com.example.practice.questiones._true.lc_142_环形链表_入环的第一个节点;

import com.example.practice.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。
 * 如果链表无环，则返回null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * <p>
 * 思路与算法
 * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。
 * 复杂度分析
 * <p>
 * 时间复杂度：O(N)，其中N为链表中节点的数目。我们恰好需要访问链表中的每一个节点。
 * 空间复杂度：O(N)，其中N为链表中节点的数目。我们需要将链表中的每个节点都保存在哈希表当中。
 */
public class Solution {

    /**
     * website test pass ✅
     */
    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> visited = new HashSet<>();
        while (current != null) {
            if (visited.contains(current)) {
                return current;
            } else {
                visited.add(current);
            }
            current = current.next;
        }
        return null;
    }
}
