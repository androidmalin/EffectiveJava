package com.example.strategy.simplefactory.optimization;

public class Client {
    public static void main(String[] args) {
        ICourse iCourse = CourseFactory.create("java");
        iCourse.record();

        ICourse iCourse1 = CourseFactory.create(PythonCourse.class);
        iCourse1.record();
    }
}
