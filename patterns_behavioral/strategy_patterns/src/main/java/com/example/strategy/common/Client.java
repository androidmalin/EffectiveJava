package com.example.strategy.common;

/**
 * 策略模式可以解决在有多种相似算法的情况下使用if...else或switch...case
 * 所带来的复杂性和臃肿性问题。
 * 在日常业务开发中，策略模式适用于以下应用场景。
 * （1）针对同一类型问题，有多种处理方式，每一种都能独立解决问题。
 * （2）需要自由切换算法的场景
 * （3）需要屏蔽算法规则的场景。
 * <p>
 * <p>
 * 策略模式的优点
 * （1）策略模式符合开闭原则。
 * （2）避免使用多重条件转移语句，如if...else语句、switch...case语句
 * （3）使用策略模式可以提高算法的保密性和安全性。
 * <p>
 * 策略模式的缺点
 * （1）客户端必须知道所有的策略，并且自行决定使用哪一个策略类。
 * （2）代码中会产生非常多策略类，增加维护难度。
 */
public class Client {

    public static void main(String[] args) {

        IStrategy strategyA = new ConcreteStrategyA();
        Context context = new Context(strategyA);
        context.algorithm();

        IStrategy strategyB = new ConcreteStrategyB();
        Context context1 = new Context(strategyB);
        context1.algorithm();
    }
}
