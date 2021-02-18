package com.example.decorator.pattern.battercake.v1;

public class BatterCakeWithEgg extends BatterCake {

    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
