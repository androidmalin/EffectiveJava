package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 相同为栈
 * addFirst=>removeFirst
 * addLast=>removeLast
 *
 * <p>
 * <p>
 * 相反为队列
 * addFirst=>removeLast
 * addLast=>removeFirst
 */
public class Java_ArrayDeque {


    @Test
    public void main() {
        queueFunction1();
        queueFunction2();
        stackFunction1();
        stackFunction2();
    }

    /**
     * addFirst=>removeLast
     * 相反==>队列
     * <p>
     * 先进先出
     * <p>
     * ①.addLast
     * <p>
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * ArrayDeque 3,  2,  1
     * index:     0,  1,  2
     * <p>
     * ②.removeLast
     * removeLast
     * 1,
     * 2,
     * 3,
     */
    @Test
    public void queueFunction1() {
        ArrayDeque<Integer> list = getAddFirstFood();
        List<Integer> foods = removeLast(list);
        List<Integer> ex = Arrays.asList(1, 2, 3);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }

    /**
     * addLast=>removeFirst
     * 相反==>队列
     *
     * <p>
     * 先进先出
     * <p>
     * ①.addLast
     * <p>
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * ArrayDeque 1,  2,  3
     * index:     0,  1,  2
     * <p>
     * ②.removeFirst
     * removeFirst
     * 1,
     * 2,
     * 3,
     */
    @Test
    public void queueFunction2() {
        ArrayDeque<Integer> list = getAddLastFood();
        List<Integer> foods = removeFirst(list);
        List<Integer> ex = Arrays.asList(1, 2, 3);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }

    /**
     * addLast=>removeLast
     * 相同==>栈
     *
     * <p>
     * 先进后出,
     * 后进先出
     * <p>
     * ①.addLast
     * <p>
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * ArrayDeque 1,  2,  3
     * index:     0,  1,  2
     * <p>
     * ②.removeLast
     * removeLast
     * 3,
     * 2,
     * 1,
     */
    @Test
    public void stackFunction1() {
        ArrayDeque<Integer> stack = getAddLastFood();
        List<Integer> foods = removeLast(stack);
        List<Integer> ex = Arrays.asList(3, 2, 1);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }


    /**
     * addFirst=>removeFirst
     * 相同==>栈
     *
     * <p>
     * 先进后出,
     * 后进先出
     * ①.addFirst
     * <p>
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * ArrayDeque 3,  2,  1
     * index:     0,  1,  2
     * <p>
     * <p>
     * ②.removeFirst
     * 3,
     * 2,
     * 1,
     */
    @Test
    public void stackFunction2() {
        ArrayDeque<Integer> stack = getAddFirstFood();
        List<Integer> foods = removeFirst(stack);
        List<Integer> ex = Arrays.asList(3, 2, 1);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }


    /**
     * 后进先出 栈
     * addFirst == removeFirst
     */
    private static List<Integer> removeFirst(ArrayDeque<Integer> foods) {
        List<Integer> result = new ArrayList<>();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Integer integer = foods.removeFirst();
            result.add(integer);
        }
        return result;
    }


    private static List<Integer> removeLast(ArrayDeque<Integer> foods) {
        List<Integer> result = new ArrayList<>();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Integer integer = foods.removeLast();
            result.add(integer);
        }
        return result;
    }


    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * ArrayDeque 3,  2,  1
     * index:     0,  1,  2
     * <p>
     * addFirst 添加
     */
    private static ArrayDeque<Integer> getAddFirstFood() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //后进先出，先放进去的在最里面，后放进去的，在最外面
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        return arrayDeque;
    }

    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * ArrayDeque 1,  2,  3
     * index:     0,  1,  2
     */
    private static ArrayDeque<Integer> getAddLastFood() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        return arrayDeque;
    }

}
