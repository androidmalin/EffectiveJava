package com.example.delegate.simple;

/**
 * 具体任务角色A
 */
public class ConcreteA implements ITask {

    @Override
    public void doTask() {
        System.out.println("执行 , 由A实现");
    }
}