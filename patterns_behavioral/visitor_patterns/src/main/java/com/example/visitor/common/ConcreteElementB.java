package com.example.visitor.common;

import java.util.Random;

/**
 * 具体元素B
 */
public class ConcreteElementB implements IElement {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public int operationB() {
        return new Random().nextInt(100);
    }
}