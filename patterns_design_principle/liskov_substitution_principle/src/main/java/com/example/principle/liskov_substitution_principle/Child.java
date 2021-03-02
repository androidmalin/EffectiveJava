package com.example.principle.liskov_substitution_principle;

public class Child extends Parent {

    @Override
    public int additionFunction(int a, int b) {
        return a - b;
    }
}
