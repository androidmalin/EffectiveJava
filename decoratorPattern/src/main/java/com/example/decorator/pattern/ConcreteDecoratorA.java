package com.example.decorator.pattern;

/**
 * 具体装饰角色
 * 负责给构件对象"贴上"附加的责任。
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        // 写相关的业务代码
        System.out.println("ConcreteDecoratorA#sampleOperation");
    }
}