package com.example.decorator.pattern;

/**
 * 具体构件角色ConcreteComponent
 * 定义一个将要接收附加责任的类。
 */
public class ConcreteComponent implements Component {
    @Override
    public void sampleOperation() {
        // 写相关的业务代码
        System.out.println("ConcreteComponent#sampleOperation");
    }
}