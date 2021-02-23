package com.example.delegate.simple;

import java.util.Random;

/**
 * 委派者角色
 */
public class Delegate implements ITask {

    @Override
    public void doTask() {
        System.out.println("代理执行开始....");
        ITask task;
        if (new Random().nextBoolean()) {
            task = new ConcreteA();
        } else {
            task = new ConcreteB();
        }
        task.doTask();
        System.out.println("代理执行完毕....");
    }
}