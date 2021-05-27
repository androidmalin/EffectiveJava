package com.example.practice.common;

import java.util.HashMap;
import java.util.Map;

/**
 * java map 的初始化问题
 */
public class Java_Map_Init {

    private static final Map<Integer, Integer> map1 = new HashMap<>();

    static {
        map1.put(1, 1);
        map1.put(2, 2);
        map1.put(3, 3);
    }

    private static final Map<Integer, Integer> map2 = new HashMap<Integer, Integer>() {{
        put(1, 1);
        put(2, 2);
        put(3, 3);
    }};

    public static void main(String[] args) {
        map1.forEach((key, value) -> System.out.println(key + " => " + value));
        map2.forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
