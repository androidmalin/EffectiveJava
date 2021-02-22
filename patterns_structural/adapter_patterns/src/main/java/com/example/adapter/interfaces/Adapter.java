package com.example.adapter.interfaces;

public abstract class Adapter implements ITarget {

    protected Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int request1() {
        return 0;
    }

    @Override
    public void function1() {

    }

    @Override
    public void function2() {

    }

    @Override
    public void function3() {

    }

    @Override
    public void function4() {

    }

    @Override
    public void function5() {

    }

    @Override
    public void function6() {

    }

    @Override
    public void function7() {

    }

    @Override
    public void function8() {

    }
}
