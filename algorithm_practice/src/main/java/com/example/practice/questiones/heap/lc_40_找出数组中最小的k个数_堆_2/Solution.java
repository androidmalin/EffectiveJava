package com.example.practice.questiones.heap.lc_40_找出数组中最小的k个数_堆_2;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，
 * 找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * <p>
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Solution {
    /**
     * 题目中已经给出了参数限制, 所以这里不再给出参数判断了
     * 限制：
     * 0 <= k <= arr.length <= 10000
     * 0 <= arr[i] <= 10000
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) return vec;// 排除 0 的情况
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        //此时queue中的数据是: 从大到小排序的
        //queue poll  操作队首(👈最左边)
        //queue offer 操作队尾(最右边👉)
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
