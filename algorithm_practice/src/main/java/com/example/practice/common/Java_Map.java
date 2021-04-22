package com.example.practice.common;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Java_Map {
    public static void main(String[] args) {
        java7();
    }

    /**
     * Java8之前的方式
     */
    public static void java7() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 1);
        items.put("B", 2);
        items.put("C", 3);
        items.put("D", 4);
        items.put("E", 5);
        items.put("F", 6);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("k:" + entry.getKey() + ", v:" + entry.getValue());
        }
    }

    /**
     * forEach + Lambda表达式
     */
    public static void java8() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 1);
        items.put("B", 2);
        items.put("C", 3);
        items.put("D", 4);
        items.put("E", 5);
        items.put("F", 6);
        items.forEach((k, v) -> System.out.println("k:" + k + ", v:" + v));
        items.forEach((k, v) -> {
            System.out.println("k:" + k + ", v:" + v);
        });
        items.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String k, Integer v) {
                System.out.println("k:" + k + ", v:" + v);
            }
        });
    }

}
