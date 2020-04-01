package com.malin.java.lib;

public class DrinkVending extends VendingService implements IVending {

    private static class AbstractVendingDelegate extends AbstractVending {
        @Override
        public void chooseProduct() {
            System.out.println("Produce different soft drinks");
            System.out.println("Choose a type of soft drinks");
            System.out.println("pay for drinks");
            System.out.println("collect drinks");
        }
    }

    private AbstractVendingDelegate delegate = new AbstractVendingDelegate();

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