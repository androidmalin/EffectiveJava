package com.example.proto.common;

public class Client {

    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("originalA");
        System.out.println("prototypeA:" + prototypeA.getDesc());

        //拷贝原型对象
        ConcretePrototypeA cloneTypeA = prototypeA.clone();
        cloneTypeA.setDesc("cloneA");
        System.out.println("cloneTypeA:" + cloneTypeA.getDesc());
        System.out.println("prototypeA:" + prototypeA.getDesc());

        //创建原型对象
        ConcretePrototypeB prototypeB = new ConcretePrototypeB("originalB");
        System.out.println("prototypeB:" + prototypeB.getDesc());

        //拷贝原型对象
        ConcretePrototypeB cloneTypeB = prototypeB.clone();
        cloneTypeB.setDesc("cloneB");
        System.out.println("cloneTypeB:" + cloneTypeB.getDesc());
        System.out.println("prototypeB:" + prototypeB.getDesc());
    }
}
