package com.malin.java.lib;

/**
 * https://dzone.com/articles/favour-skeletal-interface-in-java
 */
public class VendingManager {
    public static void main() {
        IVending candy = new CandyVending();
        IVending drink = new DrinkVending();
        candy.process();
        System.out.println("*********************");
        drink.process();


        VendingService vs = (VendingService) drink;
        vs.service();
    }
}