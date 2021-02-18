package com.example.strategy.absfactory.sample.factorys;

import com.example.strategy.absfactory.sample.products.INote;
import com.example.strategy.absfactory.sample.products.IVideo;
import com.example.strategy.absfactory.sample.products.PythonNote;
import com.example.strategy.absfactory.sample.products.PythonVideo;

public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        return new PythonNote();
    }


    public IVideo createVideo() {
        return new PythonVideo();
    }
}
