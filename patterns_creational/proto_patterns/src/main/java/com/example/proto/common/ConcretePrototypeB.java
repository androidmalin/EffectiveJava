package com.example.proto.common;

/**
 * 具体原型
 */
public class ConcretePrototypeB implements IPrototype<ConcretePrototypeB> {
    private String desc;

    public ConcretePrototypeB(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public ConcretePrototypeB clone() {
        //进行拷贝
        return new ConcretePrototypeB(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeB{" +
                "desc='" + desc + '\'' +
                '}';
    }
}