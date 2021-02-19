package com.example.strategy.simple;

/**
 * 备忘录管理者角色
 */
public class Caretaker {
    // 备忘录对象
    private IMemento memento;

    public IMemento getMemento() {
        return this.memento;
    }

    public void storeMemento(IMemento memento) {
        this.memento = memento;
    }
}