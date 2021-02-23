package com.example.mediator.common;

/**
 * 具体同事类A
 */
public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
        this.mediator.setColleagueA(this);
    }

    /**
     * 自有方法：self-Method
     */
    public void selfMethodA() {
        // 处理自己的逻辑
        System.out.println(this.getClass().getSimpleName() + ", self-Method");
    }

    /**
     * 依赖方法：dep-Method
     */
    public void depMethodA() {
        // 处理自己的逻辑
        System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
        // 无法处理的业务逻辑委托给中介者处理
        this.mediator.transferFromA_To_B();
    }
}