package com.example.bridge.pattern.common;

public class Client {
    public static void main(String[] args) {

        // 来一个实现化角色
        IImplementor imp = new ConcreteImplementorA();

        // 来一个抽象化角色，聚合实现
        Abstraction abs = new RefinedAbstraction(imp);

        // 执行操作
        abs.operation();
    }
}