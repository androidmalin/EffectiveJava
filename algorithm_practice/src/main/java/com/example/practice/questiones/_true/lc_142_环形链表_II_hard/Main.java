package com.example.practice.questiones._true.lc_142_环形链表_II_hard;

import com.example.practice.common.ListNode;

public class Main {

    public static void main(String[] args) {
        //head = [100,99,0,-100], 输出pos = 1的节点 (99)
        ListNode head = new ListNode(100);
        head.next = new ListNode(99);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-100);
        head.next.next.next.next = head.next;
        Solution solution = new Solution();
        ListNode listNode = solution.detectCycle(head);
        System.out.println(listNode.val);
    }


    private void print(ListNode head) {
        boolean reached = false;
        int num = 0;
        while (head != null && !reached) {
            System.out.println(head);
            if (head.val == 2) {
                num++;
            }
            if (num == 2) {
                reached = true;
            }
            head = head.next;
        }
    }

}
