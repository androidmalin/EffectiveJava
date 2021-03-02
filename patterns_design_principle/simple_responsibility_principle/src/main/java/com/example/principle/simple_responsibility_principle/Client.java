package com.example.principle.simple_responsibility_principle;

/**
 * 单一职责原则的定义
 * 单一职责原则（Simple Responsibility Principle，SRP)
 * 指不要存在一个以上导致类变更的原因。
 * <p>
 * 假设有一个class负责两个职责，一旦发生需求变更，修改其中一个职责的逻辑代码，
 * 有可能会导致另一个职责的功能发生故障。
 * <p>
 * 这样一来，这个class就存在两个导致类变更的原因。
 * <p>
 * 如何解决这个问题呢？我们就要分别用两个class来实现两个职责，进行解耦。
 * <p>
 * 后期需求变更维护互不影响。
 * <p>
 * 这样的设计，可以降低类的复杂度，提高类的可读性，提高系统的可维护性，降低变更引起的风险。
 * <p>
 * 总体来说就是一个class、Interface、Method只负责一项职责。
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("");
    }
}
