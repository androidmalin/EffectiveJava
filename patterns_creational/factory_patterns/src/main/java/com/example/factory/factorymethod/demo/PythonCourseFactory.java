package com.example.factory.factorymethod.demo;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse() {
        return new PythonCourse();
    }
}
