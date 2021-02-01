package com.example.decorator.pattern;

/**
 * 装饰角色
 * 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 */
public abstract class Decorator implements Component {
    private final Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // 委派给构件
        System.out.println("Decorator#sampleOperation");
        component.sampleOperation();
    }
}