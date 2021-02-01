package com.malin.java;

/**
 * 专注于 b 功能块的处理
 */
public class B extends AllWrapper {

    protected B(All all) {
        super(all);
    }

    @Override
    public void b() {
        System.out.println("B - b");
    }

    @Override
    public void X() {
        System.out.println("B - X");
        super.X();
    }
}
