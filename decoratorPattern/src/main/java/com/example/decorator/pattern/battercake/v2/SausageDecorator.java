package com.example.decorator.pattern.battercake.v2;

public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(BatterCake battercake) {
        super(battercake);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String getMsg() {
        return super.getMsg() + "+1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
