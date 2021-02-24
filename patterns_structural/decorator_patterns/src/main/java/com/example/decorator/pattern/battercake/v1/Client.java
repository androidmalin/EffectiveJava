package com.example.decorator.pattern.battercake.v1;


public class Client {

    public static void main(String[] args) {
        BatterCake battercake = new BatterCake();
        System.out.println(battercake.getMsg() + ",总价:" + battercake.getPrice());

        BatterCakeWithEgg battercakeWithEgg = new BatterCakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + ",总价:" + battercakeWithEgg.getPrice());

        BatterCakeWithEggAndSausage battercakeWithEggAndSausage = new BatterCakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() + ",总价:" + battercakeWithEggAndSausage.getPrice());
    }
}
