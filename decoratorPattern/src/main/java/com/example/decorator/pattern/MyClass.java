package com.example.decorator.pattern;

public class MyClass {
    public static void main(String[] args) {

        Component componentA = new ConcreteDecoratorA(new ConcreteComponent());
        componentA.sampleOperation();
    }
}