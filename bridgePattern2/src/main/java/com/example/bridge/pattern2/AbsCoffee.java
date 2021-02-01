package com.example.bridge.pattern2;

public abstract class AbsCoffee {

    public ICoffeeAdditives iCoffeeAdditives;

    public AbsCoffee(ICoffeeAdditives iCoffeeAdditives) {
        this.iCoffeeAdditives = iCoffeeAdditives;
    }

    public abstract void makeCoffee();
}
