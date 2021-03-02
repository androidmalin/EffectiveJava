package com.example.principle.open_close_principle;

public class JavaCourse implements ICourse {
    private final int id;
    private final String name;
    private final double price;

    public JavaCourse(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
