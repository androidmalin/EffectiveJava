package com.example.factory.factorymethod.demo;

public class Client {

    public static void main(String[] args) {
        makeJavaCourse();
        makePythonCourse();
    }

    private static void makeJavaCourse() {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse iCourse = factory.createCourse();
        iCourse.record();
    }

    private static void makePythonCourse() {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse iCourse = factory.createCourse();
        iCourse.record();
    }
}
