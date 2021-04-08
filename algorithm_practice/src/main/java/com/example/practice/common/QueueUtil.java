package com.example.practice.common;

import java.util.ArrayList;
import java.util.Arrays;
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
public class QueueUtil {

    private QueueUtil() {
    }

    private static List<Integer> getMinHeap() {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < queue.size(); i++) {
            list.add(queue.poll());
        }
        return list;
    }

    private static List<Integer> getMinHeap2() {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < queue.size(); i++) {
            list.add(queue.poll());
        }
        return list;
    }

    private static List<Integer> getMaxHeap() {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(100));
        }
        for (int i = 0; i < queue.size(); i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println("get min heap");
        List<Integer> minHeap = getMinHeap();
        System.out.println(minHeap);
        System.out.println(" ");


        System.out.println("get min heap2");
        List<Integer> minHeap2 = getMinHeap2();
        System.out.println(minHeap2);
        System.out.println(" ");

        System.out.println("get max heap");
        List<Integer> maxHeap = getMaxHeap();
        System.out.println(maxHeap);
        System.out.println(" ");

        System.out.println("printQueueRightOrder");
        printQueueRightOrder();
        System.out.println(" ");

        System.out.println("printQueueError");
        printQueueError();
        System.out.println(" ");

        System.out.println("printQueueToListRightOrder ");
        printQueueToListRightOrder();
    }

    private static void printQueueRightOrder() {
        PriorityQueue<Integer> queue = getRandomPriorityQueue(7);
        printQueueRightOrder(queue);
    }

    private static void printQueueError() {
        PriorityQueue<Integer> queue = getRandomPriorityQueue(7);
        printQueueError(queue);
    }

    private static void printQueueToListRightOrder() {
        //1.queue
        PriorityQueue<Integer> queue = getRandomPriorityQueue(7);

        //2.list
        List<Integer> list = queuePollToList(queue);
        System.out.println("  ");

        //3.list to array
        Object[] array = list.toArray();

        //4.array to String
        String result = Arrays.toString(array);

        //5.print
        System.out.println(result);
    }

    private static List<Integer> queuePollToList(Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < queue.size(); i++) {
            int element = queue.poll();
            System.out.print(element + "==>");
            list.add(element);
        }
        return list;
    }

    private static PriorityQueue<Integer> getRandomPriorityQueue(int capacity) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            queue.add(random.nextInt(100));
        }
        return queue;
    }

    private static void printQueueRightOrder(PriorityQueue<Integer> queue) {
        if (queue == null) return;
        for (int i = 0; i < queue.size(); i++) {
            int e = queue.poll();
            System.out.print(e + "==>");
        }
        System.out.println(" ");
    }

    public static void printQueueError(PriorityQueue<Integer> queue) {
        for (Integer e : queue) {
            System.out.print(e + "==>");
        }
        System.out.println("  ");
    }
}
