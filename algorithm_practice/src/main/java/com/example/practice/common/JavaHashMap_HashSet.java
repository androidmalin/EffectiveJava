package com.example.practice.common;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JavaHashMap_HashSet {

    @Test
    public void test() {
        Set<String> visited = new HashSet<>();
        visited.add("1");
        visited.add("2");
        visited.add("2");
        visited.add("3");
        visited.add("4");
        visited.forEach(System.out::println);
    }

    /**
     * HashMap是的key是不能重复的，如果有相同的key，最后一个key对应的value会把前一个相同的value覆盖掉。
     */
    @Test
    public void test2() {
        Map<String, Integer> visited = new HashMap<>();
        visited.put("1", 1);
        visited.put("1", 2);
        visited.put("3", 3);
        visited.put("4", 4);
        visited.forEach((s, integer) -> System.out.println(s + "==> " + integer));
    }
}
