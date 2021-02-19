package com.example.bridge.pattern2;

public class Test {

    public static void main(String[] args) {
        //原味
        ICoffeeAdditives ordinaryAdditives = new Ordinary();

        //糖
        ICoffeeAdditives sugarAdditives = new Sugar();

        //大杯 + 糖
        AbsCoffee largeCupSugar = new LargeCoffee(sugarAdditives);
        largeCupSugar.makeCoffee();

        //大杯 + 原味
        AbsCoffee largeCupOrd = new LargeCoffee(ordinaryAdditives);
        largeCupOrd.makeCoffee();

        //中杯 + 糖
        AbsCoffee middleCupSugar = new MiddleCoffee(sugarAdditives);
        middleCupSugar.makeCoffee();

        //中杯 + 原味
        AbsCoffee middleCupOrd = new MiddleCoffee(ordinaryAdditives);
        middleCupOrd.makeCoffee();
    }
}