package com.example.strategy.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class PromotionStrategyFactory {

    private static final IPromotionStrategy EMPTY = new EmptyStrategy();
    private static final Map<String, IPromotionStrategy> PROMOTIONS = new HashMap<>();

    static {
        PROMOTIONS.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK, new CashBackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());
    }


    private PromotionStrategyFactory() {
    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }

    public interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    public static Set<String> getPromotionKeys() {
        return PROMOTIONS.keySet();
    }
}
