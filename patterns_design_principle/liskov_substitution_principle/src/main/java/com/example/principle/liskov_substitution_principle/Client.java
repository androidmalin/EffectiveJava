package com.example.principle.liskov_substitution_principle;

/**
 * 里氏替换原则
 * <p>
 * 定义看上去比较抽象，我们重新解释一下，可以理解为一个软件实体如果适
 * 用于一个父类，则一定适用于其子类，所有引用父类的地方必须能透明地使用其
 * 子类的对象，子类对象能够替换父类对象，而程序逻辑不变。
 * <p>
 * 也可以理解为，子类可以扩展父类的功能，但不能改变父类原有的功能。
 * <p>
 * 根据这个理解，我们对里氏替换原则的定义总结如下。
 * （1）子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
 * （2）子类中可以增加自己特有的方法。
 * （3）当子类的方法重载父类的方法时，方法的前置条件（即方法的输入参数）要比父类的方法更宽松。
 * （4）当子类的方法实现父类的方法时（重写/重载或实现抽象方法），方法的后置条件（即方法的输出/返回值）要比父类的方法更严格或相等。
 */
public class Client {
    public static void main(String[] args) {
        testAdditionFunction();
    }

    /**
     * 看上去很不可思议，因为我们会发现在自己编程中常常会违反里氏替换原则，程序照样跑的好好的。
     * 所以大家都会产生这样的疑问，假如我非要不遵循里氏替换原则会有什么后果？
     * <p>
     * 我们发现原本运行正常的相加功能发生了错误。
     * <p>
     * 原因就是类Child在给方法起名时无意中重写了父类Parent的方法additionFunction()，
     * 造成所有运行相加功能的代码全部调用了类Child重写后的方法，
     * 造成原本运行正常的功能出现了错误。
     * <p>
     * 在本例中，引用基类Parent完成的功能，换成子类Child之后，发生了异常。
     * <p>
     * 在实际编程中，我们常常会通过重写父类的方法来完成新的功能，
     * 这样写起来虽然简单，但是整个继承体系的可复用性会比较差，
     * 特别是运用多态比较频繁时，程序运行出错的几率非常大。
     */
    private static void testAdditionFunction() {
        Parent parent = new Parent();
        int result = parent.additionFunction(10, 10);
        System.out.println("10 + 10 = " + result);

        Child child = new Child();
        int result2 = child.additionFunction(10, 10);
        System.out.println("10 + 10 = " + result2);
    }
}
