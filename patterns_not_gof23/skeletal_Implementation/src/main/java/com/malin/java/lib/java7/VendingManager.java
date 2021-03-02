package com.malin.java.lib.java7;

/**
 * https://dzone.com/articles/favour-skeletal-interface-in-java
 * https://www.cnblogs.com/zheming1036/p/9352333.html
 * https://www.cnblogs.com/ldzzdl/p/9061603.html
 * <p>
 * 抽象接口或者叫Skeletal Implementation
 * 是想skeletal implementation步骤:
 * Step 1: 创建一个接口.
 * Step 2: 创建一个抽象类实现这个接口，并且在抽象类中实现一些接口中的通用方法.
 * Step 3: 子类在实现接口的同时，在内部定义一个私有内部类继承抽象类．
 * 这样在就可以通过内部类调用抽象类中的已写好的方法来去除冗余代码，
 * 同时子类还可以继承其他类如VendServicing.
 * <p>
 * Skeletal Implementation优点
 * 子类可以挣脱单继承规则，继续继承其他类，如上面的VendingService.
 * 去除了冗余代码.
 * 如果子类更换一种接口实现，修改起来也很容易．
 * 总结
 * 如果你的接口中存在一些通用的方法，那么首先思考一下能不能创建一个抽象类继承该接口，实现通用方法．
 * 然后用子类实现该接口，同时在子类内部定义一个代理类继承抽象类．
 * 该方法叫skeletal implementation．(就像使用一个骨架支起一副血肉一样，形象)
 */
public class VendingManager {
    public static void main(String[] args) {
        IVending candy = new CandyVending();
        IVending drink = new DrinkVending();
        candy.process();
        System.out.println("*********************");
        drink.process();


        VendingService vs = (VendingService) drink;
        vs.service();
    }

    private static void test() {
        ToyVending toyVending = new ToyVending();
        toyVending.process();
    }
}