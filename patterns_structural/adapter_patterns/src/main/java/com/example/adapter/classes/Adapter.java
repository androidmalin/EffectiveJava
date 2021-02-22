package com.example.adapter.classes;

/**
 * 由于Adaptee没有提供sampleOperation2()方法，
 * 而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
 * <p>
 * 子类实现了接口，却由父类覆写接口中的方法 这个在类的适配器模式中使用, 感觉恰到好处
 * https://www.zhihu.com/question/60167293
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void operation2() {
        System.out.println("Adapter#operation2()");
    }
}
