package com.malin.java;

/**
 * 专注于 b 功能块的处理
 */
public class A extends AllWrapper {

    protected A(All all) {
        super(all);
    }

    @Override
    public void a() {
        System.out.println("A - a");
    }

    @Override
    public void X() {
        System.out.println("A - X");
        super.X();
    }
}
