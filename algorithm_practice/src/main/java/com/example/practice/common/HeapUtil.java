package com.example.practice.common;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 关于PriorityQueue优先级队列中元素是否有序的一个问题
 * https://blog.csdn.net/weixin_30531261/article/details/79287677
 */
public class HeapUtil {

    public static void main(String[] args) {
        printQueueDisorder();
        printQueueDisorder2();
        printQueueOrder();
        printQueueOrder2();
    }


    /**
     * 输入结果为: 5 7 6 10 8 9
     * 小顶堆只是保证根节点不大于左右子节点。但是左右子节点谁大谁小并不能保证。
     * <p>
     * ``````5``````
     * ````/```\````
     * ``7```````6``
     * `/`\`````/```
     * 10``8```9`````
     */
    private static void printQueueDisorder() {
        System.out.println("小顶堆默认输入,是无序的");
        //设置队列的初始长度为10
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        //入队
        for (int i = 10; i >= 5; i--) queue.offer(i);
        //遍历元素
        for (Integer i : queue) System.out.print(i + " ");
        System.out.println(" ");
        System.out.println(" ");
    }

    /**
     * 大顶堆
     * 例如输出
     * 9221 => 6982 => 6731 => 5426 => 5256 => 3609 => 5203 => 763 => 1130 => 2108
     */
    public static void printQueueDisorder2() {
        System.out.println("大顶堆默认输入,是无序的");
        PriorityQueue<Integer> queue = new PriorityQueue<>(10_000, (o1, o2) -> o2 - o1);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(10_000));
        }
        for (Integer i : queue) System.out.print(i + " ");
        System.out.println(" ");
    }

    /**
     * 如何让队列里的元素有序输出
     * 队列在物理结构上是数组，是无序的。但是其逻辑结构，是小顶堆，是有序的。
     * 通过poll方法让堆顶元素出列，然后会进行调整堆操作，调整之后，堆顶又是最小的元素。
     * 如此，一直出队，每次出队的都是当前堆里的最小元素（因为出队的是队头元素，而且是小顶堆，
     * 因此出队的肯定是最小元素），如此直至队列为空。就能让元素有序输出了。
     */
    public static void printQueueOrder() {
        System.out.println(" ");
        System.out.println("小顶堆有序输入,从小到大");
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        for (int i = 10; i >= 5; i--) {
            queue.offer(i);
        }
        //（此代码根上面代码的区别）通过出列的方式来遍历，而不是直接遍历
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void printQueueOrder2() {
        System.out.println(" ");
        System.out.println("大顶堆有序输入,从大到小");
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, (o1, o2) -> o2 - o1);
        for (int i = 10; i >= 5; i--) {
            queue.offer(i);
        }
        //（此代码根上面代码的区别）通过出列的方式来遍历，而不是直接遍历
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }

}
