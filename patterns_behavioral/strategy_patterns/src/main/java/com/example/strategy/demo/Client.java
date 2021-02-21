package com.example.strategy.demo;


public class Client {
    public static void main(String[] args) {
        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(PromotionStrategyFactory.PromotionKey.GROUPBUY);
        IPromotionStrategy activity = new PromotionActivity(promotionStrategy);
        activity.doPromotion();
    }
}
