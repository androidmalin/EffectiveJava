package com.example.proto.common;

public class ConcretePrototypeA implements IPrototype<ConcretePrototypeA> {
    private String desc;

    public ConcretePrototypeA(String desc) {
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public ConcretePrototypeA clone() {
        //进行拷贝
        return new ConcretePrototypeA(this.desc);
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" +
                "desc='" + desc + '\'' +
                '}';
    }
}