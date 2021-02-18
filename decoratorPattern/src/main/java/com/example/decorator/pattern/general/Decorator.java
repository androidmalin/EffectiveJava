package com.example.decorator.pattern.general;

public abstract class Decorator extends AbsComponent {
    /**
     * 持有组件对象
     */
    protected AbsComponent IAbsComponent;

    /**
     * 构造方法，传入组件对象
     *
     * @param IAbsComponent 组件对象
     */
    public Decorator(AbsComponent IAbsComponent) {
        this.IAbsComponent = IAbsComponent;
    }

    @Override
    public void operation() {
        //转发请求给组件对象，可以在转发前后执行一些附加动作
        IAbsComponent.operation();
    }
}