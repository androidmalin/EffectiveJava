package com.example.practice.questiones._true.lc_215_第K大的数;

import java.util.PriorityQueue;

@SuppressWarnings("all")
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);
        for (int num : nums) {
            minHeap.add(num);
        }

        //queue 1,2,3
        //k     2
        //poll  len-k=3-2=1
        //queue 2,3
        //peek  2(第二大的元素)
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
