package com.example.mediator.common;

/**
 * 具体同事类B
 */
public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
        this.mediator.setColleagueB(this);
    }

    // 自有方法：self-Method
    public void selfMethodB() {
        // 处理自己的逻辑
        System.out.println(this.getClass().getSimpleName() + ", self-Method");
    }

    // 依赖方法：dep-Method
    public void depMethodB() {
        // 处理自己的逻辑
        System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
        // 无法处理的业务逻辑委托给中介者处理
        this.mediator.transferFromB_To_A();
    }
}