package com.example.decorator.pattern.battercake.v2;

public class BaseBatterCake implements BatterCake {
    @Override
    public String getMsg() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
