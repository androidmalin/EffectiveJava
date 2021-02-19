package com.example.facade.simple;

/**
 * 在软件系统中，门面模式适用于以下应用场景。
 * （1）为一个复杂的模块或子系统提供一个简洁的供外界访问的接口。
 * （2）希望提高子系统的独立性时。
 * （3）当子系统由于不可避免的暂时原因导致可能存在Bug或性能相关问题时，
 * 可以通过门面模式提供一个高层接口，隔离客户端与子系统的直接交互，预防代码污染。
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
