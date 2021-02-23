package com.example.mediator.common;

/**
 * 抽象同事类
 * 每一个同事对象均需要依赖中介者角色，与其他同事间通信时，交由中介者进行转发协作。
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}