package com.example.strategy.absfactory.sample;

import com.example.strategy.absfactory.sample.factorys.JavaCourseFactory;

public class Test {
    public static void main(String[] args) {
        JavaCourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
