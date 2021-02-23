package com.example.observer.demo.guava;

public class PoJo {
    private final String name;

    public PoJo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoJo{" +
                "name='" + name + '\'' +
                '}';
    }
}
