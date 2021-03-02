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

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}
