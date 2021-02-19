package com.example.nullobj;


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