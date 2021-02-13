package com.example.memento;

public class Client {

    public static void main(String[] args) {
        ObjectFactory factory = new ObjectFactory();
        System.out.println(factory.getObject("Joe").isNull());
        System.out.println(factory.getObject("Tom").isNull());
    }
}
