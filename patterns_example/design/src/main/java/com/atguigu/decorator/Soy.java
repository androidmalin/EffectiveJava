package com.atguigu.decorator;

public class Soy extends Decorator {

    public Soy(Drink obj) {
        super(obj);
        setDescription(" 豆浆  ");
        setPrice(1.5f);
    }
}
