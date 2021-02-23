package com.example.strategy.common;

/**
 * 上下文环境
 * 上下文角色（Context):
 * 用来操作策略的上下文环境，屏蔽高层模块（客户端）
 * 对策略、算法的直接访问，封装可能存在的变化。
 * <p>
 * 注:策略模式中的上下文角色(Context)，其职责是隔离客户端与策略类的耦合，
 * 让客户端完全与上下文角色沟通，不需要关心具体策略。
 */
public class Context implements IStrategy {

    private final IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    @Override
    public void algorithm() {
        iStrategy.algorithm();
    }
}
