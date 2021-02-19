package com.example.strategy.demo;


public class CouponStrategy implements IPromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("使用优惠券抵扣");
    }
}
