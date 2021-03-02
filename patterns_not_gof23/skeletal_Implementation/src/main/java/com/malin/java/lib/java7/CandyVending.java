package com.malin.java.lib.java7;

/**
 * Step 3: 子类在实现接口的同时，在内部定义一个私有内部类继承抽象类．
 * 这样在就可以通过内部类调用抽象类中的已写好的方法来去除冗余代码，
 * 同时子类还可以继承其他类如VendServicing.
 */
public class CandyVending implements IVending {

    private static class AbstractVendingDelegate extends AbstractVending {
        @Override
        public void chooseProduct() {
            System.out.println("Produce different candies");
            System.out.println("Choose a type of candy");
            System.out.println("pay for candy");
            System.out.println("collect candy");
        }
    }

    private final AbstractVendingDelegate delegate = new AbstractVendingDelegate();

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void chooseProduct() {
        delegate.chooseProduct();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public void process() {
        delegate.process();
    }
}