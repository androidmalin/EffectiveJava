package com.example.principle.open_close_principle;

/**
 * 开闭原则（Open-ClosedPrinciple，OCP)
 * <p>
 * 指一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。
 * <p>
 * 所谓开闭，也正是对扩展和修改两个行为的一个原则。
 * <p>
 * 强调的是用抽象构建框架，用实现扩展细节，可以提高软件系统的可复用性及可维护性。
 * <p>
 * 开闭原则是面向对象设计中最基础的设计原则。
 * <p>
 * 它指导我们如何建立稳定灵活的系统，例如版本更新，我们尽可能不修改源码，但是可以增加新功能。
 * <p>
 * <p>
 * 在现实生活中，开闭原则也有体现。
 * 比如，很多互联网公司都实行弹性制作自时间，规定每天工作8小时。
 * <p>
 * 意思就是，对于每天工作8小时这个规定是关闭的，但是什么时候来、什么时候走是开放的。
 * 早来早走，晚来晚走。
 * <p>
 * <p>
 * 实现开闭原则的核心思想就是面向抽象编程。
 */
public class Client {

    public static void main(String[] args) {
        JavaDiscountCourse discountCourse = new JavaDiscountCourse(1, "Java架构", 11800D);
        System.out.println("课程ID：" + discountCourse.getId() +
                "\n课程标题：《" + discountCourse.getName() + "》" +
                "\n原价：" + discountCourse.getPrice() +
                "\n售价：" + discountCourse.getDiscountPrice());
    }

}
