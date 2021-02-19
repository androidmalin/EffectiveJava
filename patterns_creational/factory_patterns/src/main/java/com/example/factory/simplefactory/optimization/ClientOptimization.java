package com.example.factory.simplefactory.optimization;

public class ClientOptimization {

    public static void main(String[] args) {
        ICourse iCourse = CourseFactoryOptimization.create(PythonCourse.class);
        iCourse.record();
    }
}
