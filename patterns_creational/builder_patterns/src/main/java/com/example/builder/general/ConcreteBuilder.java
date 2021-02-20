package com.example.builder.general;

public class ConcreteBuilder implements IBuilder {
    private final Product product = new Product();

    @Override
    public Product build() {
        return product;
    }
}