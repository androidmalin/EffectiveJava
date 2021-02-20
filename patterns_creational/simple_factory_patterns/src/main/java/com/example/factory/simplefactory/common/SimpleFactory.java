package com.example.factory.simplefactory.common;

public class SimpleFactory {
    public static IProduct makeProduct(int kind) {
        switch (kind) {
            case Const.PRODUCT_B: {
                return new ConcreteProductB();
            }
            case Const.PRODUCT_C: {
                return new ConcreteProductC();
            }
            case Const.PRODUCT_A: {
                return new ConcreteProductA();
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + kind);
            }
        }
    }
}