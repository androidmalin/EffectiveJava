package com.example.memento.absfactory.sample.factorys;

import com.example.memento.absfactory.sample.products.INote;
import com.example.memento.absfactory.sample.products.IVideo;
import com.example.memento.absfactory.sample.products.PythonNote;
import com.example.memento.absfactory.sample.products.PythonVideo;

public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        return new PythonNote();
    }


    public IVideo createVideo() {
        return new PythonVideo();
    }
}
