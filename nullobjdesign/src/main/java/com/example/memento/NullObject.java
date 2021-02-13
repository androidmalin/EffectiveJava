package com.example.memento;


//空对象
public class NullObject extends AbstractObject {

    @Override
    public void request() {
        System.out.println("Not Available Request");
    }

    @Override
    boolean isNull() {
        return true;
    }
}