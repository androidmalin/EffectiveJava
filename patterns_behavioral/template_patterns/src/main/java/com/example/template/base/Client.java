package com.example.template.base;

public class Client {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMethod();

        System.out.println("=======");

        abc = new ConcreteClassB();
        abc.templateMethod();
    }
}
