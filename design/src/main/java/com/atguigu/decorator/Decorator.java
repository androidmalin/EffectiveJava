package com.atguigu.decorator;

public class Decorator extends Drink {
    private final Drink drink;

    //组合
    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    /**
     * 输出被装饰者的信息
     */
    @Override
    public String getDescription() {
        return description + " " + getPrice() + " && " + drink.getDescription();
    }
}
