package com.example.strategy.demo;


public class PromotionActivity implements IPromotionStrategy {
    private final IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void doPromotion() {
        strategy.doPromotion();
    }
}
