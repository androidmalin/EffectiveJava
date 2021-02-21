package com.example.memento.common;

/**
 * 发起人角色
 */
public class Originator {
    // 内部状态
    private String state;

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * 创建一个备忘录
     */
    public Memento createMemento() {
        return new Memento(this.state);
    }

    /**
     * 从备忘录恢复
     */
    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}