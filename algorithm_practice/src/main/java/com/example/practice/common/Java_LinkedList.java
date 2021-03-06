package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
public class Java_LinkedList {


    @Test
    public void main() {
        queueFunction1();
        queueFunction2();
        stackFunction1();
        stackFunction2();
    }

    /**
     * addFirst=>removeLast
     * <p>
     * 先进先出
     * <p>
     * ①.addLast
     * <p>
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
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
        LinkedList<Integer> list = getAddFirstFood();
        print(list);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Integer> foods = removeLast(list);
        print(foods);
        List<Integer> ex = Arrays.asList(1, 2, 3);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }

    /**
     * addLast=>removeFirst
     * <p>
     * 先进先出
     * <p>
     * ①.addLast
     * <p>
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
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
        LinkedList<Integer> list = getAddLastFood();
        print(list);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Integer> foods = removeFirst(list);
        print(foods);

        List<Integer> ex = Arrays.asList(1, 2, 3);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }

    /**
     * addLast=>removeLast
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
     * LinkedList 1,  2,  3
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
        LinkedList<Integer> stack = getAddLastFood();
        print(stack);

        System.out.println(" ");
        System.out.println("removeLast集合后 ");
        List<Integer> foods = removeLast(stack);
        print(foods);

        List<Integer> ex = Arrays.asList(3, 2, 1);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }


    /**
     * addFirst=>removeFirst
     * <p>
     * 先进后出,
     * 后进先出
     * ①.addFirst
     * <p>
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
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
        LinkedList<Integer> stack = getAddFirstFood();
        print(stack);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Integer> foods = removeFirst(stack);
        print(foods);

        List<Integer> ex = Arrays.asList(3, 2, 1);
        Assertions.assertTrue(ListUtil.isSame(ex, foods));
    }

    private static void print(List<Integer> list) {
        System.out.println("");
        System.out.println("当前List从左到右依次为:");
        for (int i = 0; i < list.size(); i++) {
            //顺序输出，此处按照first方式输出，先输出薯片
            System.out.print(list.get(i) + " ==> ");
        }
        System.out.println(" ");
    }


    /**
     * 后进先出 栈
     * addFirst == removeFirst
     */
    private static List<Integer> removeFirst(LinkedList<Integer> foods) {
        List<Integer> result = new ArrayList<>();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Integer integer = foods.removeFirst();
            result.add(integer);
        }
        return result;
    }


    private static List<Integer> removeLast(LinkedList<Integer> foods) {
        List<Integer> result = new ArrayList<>();
        System.out.println(" ");
        System.out.println("removeLast 输出");
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Integer integer = foods.removeLast();
            System.out.print(integer + " , ");
            result.add(integer);
        }
        System.out.println();
        return result;
    }


    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
     * index:     0,  1,  2
     * <p>
     * addFirst 添加
     */
    private static LinkedList<Integer> getAddFirstFood() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        //后进先出，先放进去的在最里面，后放进去的，在最外面
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        System.out.println("addFirst加入顺序:");
        System.out.print(1 + " , " + 2 + " , " + 3);
        System.out.println(" ");
        return linkedList;
    }

    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
     * index:     0,  1,  2
     */
    private static LinkedList<Integer> getAddLastFood() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        System.out.println("addLast加入顺序:");
        System.out.print(1 + " , " + 2 + " , " + 3);
        System.out.println(" ");
        return linkedList;
    }

}
