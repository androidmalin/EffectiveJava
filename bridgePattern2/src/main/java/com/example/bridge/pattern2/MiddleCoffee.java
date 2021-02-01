package com.example.bridge.pattern2;

public class MiddleCoffee extends AbsCoffee {

    public MiddleCoffee(ICoffeeAdditives iCoffeeAdditives) {
        super(iCoffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("中杯 加" + iCoffeeAdditives.add() + " 咖啡");
    }
}
