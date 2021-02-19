package com.malin.java.lib.java8;

public class VendingManager {
    public static void main(String[] args) {
        IVending candy = new CandyVending();
        candy.process();
    }
}