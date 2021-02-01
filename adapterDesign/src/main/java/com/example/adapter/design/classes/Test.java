package com.example.adapter.design.classes;


/**
 * 类的适配器模式
 * 将一个类的接口转换成客户希望的另外一个接口。
 * Adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * <p>
 * 主要角色：
 * Target（目标）：这就是所期待得到的接口。注意：由于这里讨论的是类适配器模式，因此目标不可以是类。
 * Adaptee(源，即被适配者)：现在需要适配的接口。
 * Adapter（适配器）：适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 */
public class Test {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.operation1();
        target.operation2();
    }
}
