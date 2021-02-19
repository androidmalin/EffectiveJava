package com.example.factory.simplefactory.optimization;

public class Client {
    public static void main(String[] args) {
        ICourse iCourse = CourseFactory.create("java");
        iCourse.record();
    }
}
