package com.example.practice.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static String get(ListNode head) {
        StringBuilder result = new StringBuilder();
        ListNode current = head;
        if (current == null) return "null";
        while (current != null) {
            result.append(current.val);
            result.append("-->");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }

    /**
     * 打印环形链表
     */
    public static void printCycleListNode(ListNode head, int cycleValue) {
        ListNode current = head;
        boolean reached = false;
        int num = 0;
        while (current != null && !reached) {
            System.out.print(current + " ==> ");
            if (current.val == cycleValue) {
                num++;
            }
            if (num == 2) {
                reached = true;
            }
            current = current.next;
        }
    }
}
