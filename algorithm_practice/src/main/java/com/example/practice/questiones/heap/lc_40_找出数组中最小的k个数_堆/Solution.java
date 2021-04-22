package com.example.practice.questiones.heap.lc_40_找出数组中最小的k个数_堆;

import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，
 * 找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
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
 * <p>
 * 深入理解Java  PriorityQueue
 * <p>
 * 通过堆实现，具体说是通过完全二叉树（complete binary tree）
 * 实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），
 * 也就意味着可以通过数组来作为PriorityQueue的底层实现。
 * <p>
 * https://www.cnblogs.com/CarpenterLee/p/5488070.html
 */
public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : arr) {
            queue.add(value);
        }
        //此时queue中的数据是: 从小到大排序的
        //queue poll  返回队首元素,即队列中最少的值
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
