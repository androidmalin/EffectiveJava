package com.example.strategy.demo;


public class Test {
    public static void main(String[] args) {
        IPromotionStrategy promotionStrategy = PromotionStrategyFactory.getPromotionStrategy(PromotionStrategyFactory.PromotionKey.GROUPBUY);
        PromotionActivity activity = new PromotionActivity(promotionStrategy);
        activity.execute();
    }
}
