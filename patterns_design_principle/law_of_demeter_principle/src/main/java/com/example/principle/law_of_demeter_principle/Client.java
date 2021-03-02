package com.example.principle.law_of_demeter_principle;


/**
 * 迪米特法则（Law of Demeter，LoD）
 * 又叫作最少知道原则（Least Knowledge Principle，LKP），
 * <p>
 * 指一个对象应该对其他对象保持最少的了解，尽量降低类与类之间的耦合。
 * <p>
 * 迪米特法则主要强调只和朋友交流，不和陌生人说话。
 * <p>
 * 出现在成员变量、方法的输入和输出参数中的类都可以被称为成员朋友类，
 * 而出现在方法体内部的类不属于朋友类。
 * <p>
 * <p>
 * 使用里氏替换原则有以下优点
 * （1）约束继承泛滥，是开闭原则的一种体现。
 * （2）加强程序的健壮性，同时变更时可以做到非常好的兼容性，
 * 提高程序的维护性、可扩展性，降低需求变更时引入的风险。
 */
public class Client {
    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);
    }
}
