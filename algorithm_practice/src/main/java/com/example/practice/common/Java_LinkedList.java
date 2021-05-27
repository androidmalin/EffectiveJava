package com.example.practice.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Java_LinkedList {

    /**
     * 相同为栈
     * 相反为队列
     */
    public static void main(String[] args) {
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
    private static void queueFunction1() {
        LinkedList<Food> list = getAddFirstFood();
        print(list);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Food> foods = removeLast(list);
        print(foods);
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
    private static void queueFunction2() {
        LinkedList<Food> list = getAddLastFood();
        print(list);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Food> foods = removeFirst(list);
        print(foods);
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
    private static void stackFunction1() {
        LinkedList<Food> stack = getAddLastFood();
        print(stack);

        System.out.println(" ");
        System.out.println("removeLast集合后 ");
        List<Food> foods = removeLast(stack);
        print(foods);
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
    private static void stackFunction2() {
        LinkedList<Food> stack = getAddFirstFood();
        print(stack);

        System.out.println(" ");
        System.out.println("removeFirst集合后 ");
        List<Food> foods = removeFirst(stack);
        print(foods);
    }

    private static void print(List<Food> foods) {
        System.out.println("");
        System.out.println("当前List从左到右依次为:");
        for (int i = 0; i < foods.size(); i++) {
            //顺序输出，此处按照first方式输出，先输出薯片
            System.out.print(((Food) foods.get(i)).name + " ==> ");
        }
        System.out.println(" ");
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
    private static void addFirst() {
        LinkedList<Food> foods = getAddFirstFood();
        System.out.println("从左边到右边的顺序为");
        for (int i = 0; i < foods.size(); i++) {
            //顺序输出，此处按照first方式输出，先输出薯片
            System.out.print(((Food) foods.get(i)).name + " ==> ");
        }
        System.out.println(" ");
    }

    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
     * index:     0,  1,  2
     */
    private static void addFirs1() {
        LinkedList<Food> foods = getAddFirstFood();

        System.out.println("getFirst输出");
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.getFirst();
            System.out.println(food.name);
        }
    }

    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
     * index:     0,  1,  2
     */
    private static void addFirs2() {
        System.out.println("getLast输出");
        LinkedList<Food> foods = getAddFirstFood();
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.getLast();
            System.out.println(food.name);
        }
    }


    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
     * index:     0,  1,  2
     * <p>
     * TODO:
     * 后进先出
     * addFirst == removeFirst
     */
    private static void removeFirst() {
        System.out.println(" ");
        System.out.println("removeFirst 输出");
        LinkedList<Food> foods = getAddFirstFood();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Food food = foods.removeFirst();
            System.out.print(food.name + " ==> ");
        }
        System.out.println();
    }

    /**
     * 后进先出 栈
     * addFirst == removeFirst
     */
    private static List<Food> removeFirst(LinkedList<Food> foods) {
        List<Food> result = new ArrayList<>();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Food food = foods.removeFirst();
            result.add(food);
        }
        return result;
    }

    /**
     * addFirst 1
     * addFirst 2
     * addFirst 3
     * <p>
     * LinkedList 3,  2,  1
     * index:     0,  1,  2
     */
    private static void removeLast() {
        System.out.println(" ");
        System.out.println("removeLast 输出");
        LinkedList<Food> foods = getAddFirstFood();
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Food food = foods.removeLast();
            System.out.print(food.name + " ==> ");
        }
        System.out.println();
    }

    private static List<Food> removeLast(LinkedList<Food> foods) {
        List<Food> result = new ArrayList<>();
        System.out.println(" ");
        System.out.println("removeLast 输出");
        final int size = foods.size();
        for (int i = 0; i < size; i++) {
            Food food = foods.removeLast();
            System.out.print(food.name + " , ");
            result.add(food);
        }
        System.out.println();
        return result;
    }


    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
     * index:     0,  1,  2
     */
    private static void addLast() {
        LinkedList<Food> foods = getAddLastFood();
        for (int i = 0; i < foods.size(); i++) {
            //顺序输出
            System.out.println(((Food) foods.get(i)).name);
        }
    }

    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
     * index:     0,  1,  2
     * 左边==>右边
     */
    private static void addLast1() {
        LinkedList<Food> foods = getAddLastFood();

        System.out.println("getLast输出");
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.getFirst();
            System.out.println(food.name);
        }
    }

    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
     * index:     0,  1,  2
     */
    private static void addLast2() {
        LinkedList<Food> foods = getAddLastFood();

        System.out.println("getLast输出");
        for (int i = 0; i < foods.size(); i++) {
            Food food = foods.getLast();
            System.out.println(food.name);
        }
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
    private static LinkedList<Food> getAddFirstFood() {
        LinkedList<Food> foods = new LinkedList<>();
        Food food1 = new Food(1, 1);
        Food food2 = new Food(2, 2);
        Food food3 = new Food(3, 3);

        //后进先出，先放进去的在最里面，后放进去的，在最外面
        foods.addFirst(food1);
        foods.addFirst(food2);
        foods.addFirst(food3);
        System.out.println("addFirst加入顺序:");
        System.out.print(food1.id + " , " + food2.id + " , " + food3.id);
        System.out.println(" ");
        return foods;
    }

    /**
     * addLast 1
     * addLast 2
     * addLast 3
     * <p>
     * LinkedList 1,  2,  3
     * index:     0,  1,  2
     */
    private static LinkedList<Food> getAddLastFood() {
        LinkedList<Food> foods = new LinkedList<>();
        Food food1 = new Food(1, 1);
        Food food2 = new Food(2, 2);
        Food food3 = new Food(3, 3);

        foods.addLast(food1);
        foods.addLast(food2);
        foods.addLast(food3);
        System.out.println("addLast加入顺序:");
        System.out.print(food1.id + " , " + food2.id + " , " + food3.id);
        System.out.println(" ");
        return foods;
    }

    private static class Food {
        public int id;
        public int name;

        public Food(int id, int name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" +
                    "no=" + id +
                    ", name=" + name +
                    '}';
        }
    }

}
