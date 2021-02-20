package com.example.factory.absfactory.demo;

public class PythonCourseFactory implements ICourseFactory {

    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
