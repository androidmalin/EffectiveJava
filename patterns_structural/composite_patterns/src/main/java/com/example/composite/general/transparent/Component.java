package com.example.composite.general.transparent;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();

    public boolean addChild(Component component) {
        return false;
    }

    public boolean removeChild(Component component) {
        return false;
    }

    public Component getChild(int index) {
        return null;
    }
}