package com.malin.java;

public abstract class AllWrapper extends All {
    private final All base;

    protected AllWrapper(All all) {
        base = all;
    }

    @Override
    public void a() {
        base.a();
    }

    @Override
    public void b() {
        base.b();
    }

    @Override
    public void c() {
        base.c();
    }

    @Override
    public void X() {
        base.X();
    }
}