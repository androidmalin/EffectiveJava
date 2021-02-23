package com.malin.java.lib.java7;

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