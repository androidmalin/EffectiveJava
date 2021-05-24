package com.example.practice.common;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

public class Java_AbstractMap {

    @Test
    public void mapTest() {
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<>("name", "jake");
        System.out.println("new AbstractMap.SimpleEntry: " + entry);
        System.out.println("getKey: " + entry.getKey());
        System.out.println("getValue: " + entry.getValue());
        System.out.println(" ");
        entry.setValue("jake2");
        System.out.println("setValue: jake2");
        System.out.println("getKey: " + entry.getKey());
        System.out.println("getValue: " + entry.getValue());
    }
}
