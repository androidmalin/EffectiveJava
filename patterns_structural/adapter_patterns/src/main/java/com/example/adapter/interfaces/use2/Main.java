package com.example.adapter.interfaces.use2;

/**
 * https://stackoverflow.com/questions/13670991/can-we-instantiate-an-abstract-class
 * 您不能实例化抽象类，但是可以实例化抽象类的具体子类
 */
public class Main {
    public static void main(String[] str) {
        My m = new My() {
        };
        m.myMethod();
    }
}