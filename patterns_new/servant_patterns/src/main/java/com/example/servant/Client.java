package com.example.servant;


/**
 * 雇工模式的定义
 * 雇工模式（EmployeePattern）也叫作仆人模式（ServantPattern），
 * 属于行为型设计模式，它为一组类提供通用的功能，而不需要类实现这些功能，
 * 也是命令模式的一种扩展。
 * <p>
 * 雇工模式与命令模式非常相似，其实雇工模式
 * 是命令模式的一种简化，但更符合实际需要，更容易进入开发场景中。
 * <p>
 * <p>
 * 雇工模式的优缺点
 * 1.优点
 * 扩展性良好，可以很容易地增加雇工来执行新的任务。
 * <p>
 * 2.缺点
 * 增加了程序的复杂度。
 */
public class Client {

    public static void main(String[] args) {
        Servant servant = new Servant();
        servant.service(new ConcreteServiced1());
        servant.service(new ConcreteServiced2());
    }
}