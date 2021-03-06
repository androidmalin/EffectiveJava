package com.example.practice.questiones.heap.lc_703_数据流中的第K大元素.review;


import java.util.PriorityQueue;

/**
 * 703.
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
