package com.example.practice.questiones._true.剑指_Offer_09_用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * appendTail 在队列尾部插入整数
 * <p>
 * deleteHead 在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 */
public class CQueue {
    private final Deque<Integer> stack1;
    private final Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
