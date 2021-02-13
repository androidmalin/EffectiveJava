package com.example.memento.absfactory.sample.products;

public class PythonCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
