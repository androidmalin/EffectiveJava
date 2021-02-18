package com.example.delegate.simple;

/**
 * 具体任务角色B
 */
public class ConcreteB implements ITask {

    @Override
    public void doTask() {
        System.out.println("执行 , 由B实现");
    }
}