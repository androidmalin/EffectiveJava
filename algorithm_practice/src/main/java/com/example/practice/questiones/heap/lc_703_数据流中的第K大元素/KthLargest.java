package com.example.practice.questiones.heap.lc_703_数据流中的第K大元素;

import java.util.PriorityQueue;

/**
 * 703.
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * <p>
 * 解题思路:
 * 优先队列
 * 我们可以使用一个大小为 k 的优先队列来存储前 k 大的元素，
 * 其中优先队列的队头为队列中最小的元素，也就是第 k 大的元素。
 * 在单次插入的操作中，我们首先将元素 val 加入到优先队列中。
 * 如果此时优先队列的大小大于 k，我们需要将优先队列的队头元素弹出，以保证优先队列的大小为 k。
 */
public class KthLargest {
    final PriorityQueue<Integer> q = new PriorityQueue<>();
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        q.offer(val);
        if (q.size() > k) q.poll();
        return q.peek();
    }
}
