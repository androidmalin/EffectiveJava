package com.example.decorator.pattern.general;

//具体装饰器B
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(AbsComponent IAbsComponent) {
        super(IAbsComponent);
    }

    /**
     * 在调用父类的operation方法之前需要执行的操作
     */
    private void operationFirst() {
    }

    /**
     * 在调用父类的operation方法之后需要执行的操作
     */
    private void operationLast() {
    }

    @Override
    public void operation() {
        //调用父类的方法，可以在调用前后执行一些附加动作
        //添加的功能
        operationFirst();

        //这里可以选择性的调用父类的方法，如果不调用则相当于完全改写了方法，实现了新的功能
        super.operation();

        //添加的功能
        operationLast();
    }
}