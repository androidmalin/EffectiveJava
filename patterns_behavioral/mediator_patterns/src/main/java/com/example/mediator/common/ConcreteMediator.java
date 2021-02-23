package com.example.mediator.common;

/**
 * 具体中介者
 * 从具体的同事对象接受消息,向具体的同事对象发出命令,协调各同事间的协作
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void transferFromA_To_B() {
        // 协调行为:A 转发到 B
        this.colleagueB.selfMethodB();
    }

    @Override
    public void transferFromB_To_A() {
        // 协调行为:B 转发到 A
        this.colleagueA.selfMethodA();
    }
}