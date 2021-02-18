package com.example.decorator.pattern.battercake.v2;


public class Test {

    public static void main(String[] args) {
        BatterCake battercake;

        battercake = new BaseBatterCake();

        battercake = new EggDecorator(battercake);

        battercake = new EggDecorator(battercake);

        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMsg() + "，总价:" + battercake.getPrice());
    }

}
