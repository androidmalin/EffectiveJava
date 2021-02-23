package com.example.mediator.common;

/**
 * 抽象中介者 (Mediator): 定义统一的接口,用于各个同事角色之间通讯.
 */
public abstract class Mediator {
    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleague) {
        this.colleagueA = colleague;
    }

    public void setColleagueB(ConcreteColleagueB colleague) {
        this.colleagueB = colleague;
    }

    /**
     * 中介者业务逻辑
     */
    public abstract void transferFromA_To_B();

    public abstract void transferFromB_To_A();
}