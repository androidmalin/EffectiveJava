package com.example.decorator.pattern.battercake.v2;

public abstract class BatterCakeDecorator implements BatterCake {

    private final BatterCake battercake;

    public BatterCakeDecorator(BatterCake battercake) {
        this.battercake = battercake;
    }

    public abstract void doSomething();

    @Override
    public String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    public int getPrice() {
        return this.battercake.getPrice();
    }
}
