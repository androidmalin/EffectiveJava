package com.example.principle.open_close_principle;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(int id, String name, double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.6;
    }
}
