package com.example.factory.absfactory.demo;


public class Client {
    public static void main(String[] args) {
        makeJavaCourse();
        makePythonCourse();
    }

    private static void makeJavaCourse() {
        ICourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }

    private static void makePythonCourse() {
        ICourseFactory factory = new PythonCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
