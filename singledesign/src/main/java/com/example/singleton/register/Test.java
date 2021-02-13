package com.example.singleton.register;

public class Test {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setData("hello");
        Object data = instance.getData();
        System.out.println(data);
    }
}
