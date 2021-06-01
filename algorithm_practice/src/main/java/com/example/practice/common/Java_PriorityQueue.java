package com.example.practice.common;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，
 * 对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
 * <p>
 * 要使用PriorityQueue，我们就必须给每个元素定义"优先级"
 * <p>
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152
 * <p>
 * <p>
 * 小顶堆，最小的元素在顶端
 * 大顶堆，最大的元素在顶端
 */
public class Java_PriorityQueue {

    public static void main(String[] args) {
        System.out.println("get min heap");
        List<Integer> minHeap = getMinHeap2();
        System.out.println(minHeap);
        System.out.println(" ");


        System.out.println("get max heap");
        List<Integer> maxHeap = getMaxHeap();
        System.out.println(maxHeap);
        System.out.println(" ");

    }

    /**
     * 默认小顶堆
     * 小顶堆，最小的元素在顶端
     */
    private static List<Integer> getMinHeap() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        addDataToPriorityQueue(queue, 6);
        return getListFromPriorityQueue(queue);
    }

    /**
     * 小顶堆 o1 - o2
     * 小顶堆，最小的元素在顶端
     */
    private static List<Integer> getMinHeap2() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        addDataToPriorityQueue(queue, 5);
        return getListFromPriorityQueue(queue);
    }

    /**
     * 大顶堆 o2 - o1
     * 大顶堆，最大的元素在顶端
     */
    private static List<Integer> getMaxHeap() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        addDataToPriorityQueue(queue, 5);
        return getListFromPriorityQueue(queue);
    }

    private static void addDataToPriorityQueue(Queue<Integer> queue, int num) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            queue.add(random.nextInt(100));
        }
    }

    private static List<Integer> getListFromPriorityQueue(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        final int size = queue.size();
        for (int i = 0; i < size; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
