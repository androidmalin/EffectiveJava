package com.example.adapter.classes;


/**
 * 类的适配器模式
 * <p>
 * 类适配器的原理就是通过继承来实现适配器功能。
 * 具体做法是，让Adapter实现Target接口，并且继承Adaptee，
 * 这样Adapter就具备了ITarget和Adaptee的特性，可以将两者进行转化。
 * <p>
 * 将一个类的接口转换成客户希望的另外一个接口。
 * Adapter 模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * <p>
 * 主要角色:
 * Target（目标）:这就是所期待得到的接口。
 * Adaptee(源，即被适配者):现在需要适配的类。
 * Adapter（适配器）:适配器类是本模式的核心。
 * 适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 */
public class Client {
    public static void main(String[] args) {
        Target Target = new Adapter();
        Target.operation1();
        Target.operation2();
    }
}
