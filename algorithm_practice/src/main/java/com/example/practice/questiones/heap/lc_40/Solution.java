package com.example.practice.questiones.heap.lc_40;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


class Solution {

    /**
     * 不要陷入死胡同,
     * 没有要求输出的数据需要排序
     * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * 1.若目前堆的大小小于K，将当前数字放入堆中。
     * 2.否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                System.out.println("pq.offer(num) " + num);
                pq.offer(num);
            } else if (num < pq.peek()) {
                for (int e : pq) {
                    System.out.print(e + "====>");
                }
                System.out.println("=============");
                Integer poll = pq.poll();
                pq.offer(num);
                System.out.println("num < pq.peek(): poll=" + poll + ",offer=" + num);
                for (int e : pq) {
                    System.out.print(e + "=>");
                }
                System.out.println("  ");
            }
        }


        for (int e : pq) {
            System.out.print(e + "====>");
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }


    //3, 90, 20, 1, 2, 0
    public static void main(String[] args) {
        List<Integer> list = insertSort();
        System.out.println(list);
    }

    private static List<Integer> insertSort() {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < queue.size(); i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void print(PriorityQueue<Integer> queue) {
        for (Integer i : queue) {
            System.out.print(i + "==>");
        }
        System.out.println("  ");
    }
}
