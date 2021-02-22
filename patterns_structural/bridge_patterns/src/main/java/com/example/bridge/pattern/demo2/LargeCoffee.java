package com.example.bridge.pattern.demo2;

public class LargeCoffee extends AbsCoffee {

    public LargeCoffee(ICoffeeAdditives iCoffeeAdditives) {
        super(iCoffeeAdditives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯 加" + iCoffeeAdditives.add() + " 咖啡");
    }
}
