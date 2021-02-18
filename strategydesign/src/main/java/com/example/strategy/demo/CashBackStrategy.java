package com.example.strategy.demo;


public class CashBackStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
