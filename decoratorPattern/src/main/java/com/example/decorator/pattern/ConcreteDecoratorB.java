package com.example.decorator.pattern;

/**
 * 具体装饰角色
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        super.sampleOperation();
        //写相关的业务代码
    }
}