package com.example.template.common;

/**
 * 抽象模板类
 * 抽象模板(AbstractClass）
 * 抽象模板类，定义了一套算法框架/流程.
 */
public abstract class AbstractClass {

    protected void step1() {
        System.out.println("AbstractClass:step1");
    }

    protected void step2() {
        System.out.println("AbstractClass:step2");
    }

    protected void step3() {
        System.out.println("AbstractClass:step3");
    }

    /**
     * 声明为final方法，避免子类覆写
     * <p>
     * 通常把抽象模板类AbstractClass的模板方法templateMethod()定义成final类型的方法，
     * 避免子类对其覆写，并定义算法结构/流程的语义。
     */
    public final void templateMethod() {
        this.step1();
        this.step2();
        this.step3();
    }
}