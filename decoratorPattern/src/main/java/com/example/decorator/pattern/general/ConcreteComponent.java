package com.example.decorator.pattern.general;

/**
 * 具体构件角色ConcreteComponent
 * 定义一个将要接收附加责任的类。
 */
public class ConcreteComponent extends AbsComponent {
    @Override
    public void operation() {
        //相应的功能处理
        System.out.println("处理业务逻辑");
    }
}