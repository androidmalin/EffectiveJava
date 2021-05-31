package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 1.需要线程同步
 * 使用Collections工具类中synchronizedXxx()将线程不同步的ArrayDeque以及LinkedList转换成线程同步。
 * 2.频繁的插入、删除操作：LinkedList
 * 3.频繁的随机访问操作：ArrayDeque
 * 4.未知的初始数据量：LinkedList
 * <p>
 * ArrayDeque和 LinkedList正在实现Deque接口，但实现方式有所不同。
 * <p>
 * 主要区别：
 * ArrayDeque类是的可调整大小的数组实现的Deque接口和链表类是列表实现
 * 可以将NULL元素添加到LinkedList，但不能添加到ArrayDeque中
 * ArrayDeque比LinkedList更有效对于两端的添加和删除操作，LinkedList实现对于在迭代过程中删除当前元素非常有效。
 * 该链表实现消耗比更多的内存ArrayDeque
 * 因此，如果您不必支持NULL元素&&寻找较少的内存，并且&&在两端添加/删除元素的效率都很高， ArrayDeque是最好的
 * <p>
 * <p>
 * https://stackoverflow.com/questions/6129805/what-is-the-fastest-java-collection-with-the-basic-functionality-of-a-queue
 */
public class Java_Deque {

    @Test
    public void test() {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A -> B
        deque.offerFirst("C"); // C -> A -> B

        //当前 C -> A -> B
        Assertions.assertEquals("C", deque.pollFirst());

        //当前 A -> B
        Assertions.assertEquals("B", deque.pollLast());

        //当前 A->null
        Assertions.assertEquals("A", deque.pollFirst());

        //当前 null
        Assertions.assertNull(deque.pollFirst());

    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void whenDerivedExceptionThrown_thenAssertionSuccess() {
        Exception exception = assertThrows(RuntimeException.class, () -> Integer.parseInt("1a"));
        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    /**
     * ArrayDeque 中不能添加 null
     */
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void test1() {
        boolean nullPointerException = false;
        try {
            Deque<String> deque = new ArrayDeque<>();
            deque.offerFirst(null);
        } catch (NullPointerException e) {
            nullPointerException = true;
        }
        Assertions.assertTrue(nullPointerException);
    }

    /**
     * LinkedList 中 可以 能添加 null
     */
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Test
    public void test2() {
        boolean nullPointerException = false;
        try {
            Deque<String> deque = new LinkedList<>();
            deque.offerFirst(null);
        } catch (NullPointerException e) {
            nullPointerException = true;
        }
        Assertions.assertFalse(nullPointerException);
    }

}
