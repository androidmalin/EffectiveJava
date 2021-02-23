package com.example.mediator.common;


/**
 * (1)抽象中介者 (Mediator): 定义统一的接口,用于各个同事角色之间通讯.
 * (2)具体中介者 (ConcreteMediator):
 * 从具体的同事对象接受消息,向具体的同事对象发出命令,协调各同事间的协作
 * <p>
 * (3)抽象同事类(Colleague):
 * 每一个同事对象均需要依赖中介者角色，与其他同事间通信时，交由中介者进行转发协作。
 * (4)具体同事类(ConcreteColleague):
 * 负责实现自发行为(Self-Method)，转发依赖方法(Dep-Method)交由中介者进行协调。
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        colleagueA.depMethodA();
        System.out.println("-------------------------");
        colleagueB.depMethodB();
    }
}
