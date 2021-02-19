package com.atguigu.decorator;

public class Milk extends Decorator {

    public Milk(Drink obj) {
        super(obj);
        setDescription(" 牛奶 ");
        setPrice(2.0f);
    }
}
