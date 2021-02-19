package com.example.composite.demo.safe;


public abstract class Direcotry {
    protected String name;

    public Direcotry(String name) {
        this.name = name;
    }

    public abstract void show();
}
