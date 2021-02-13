package com.example.memento.absfactory.sample.factorys;

import com.example.memento.absfactory.sample.products.INote;
import com.example.memento.absfactory.sample.products.IVideo;
import com.example.memento.absfactory.sample.products.JavaNote;
import com.example.memento.absfactory.sample.products.JavaVideo;

public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        return new JavaNote();
    }

    public IVideo createVideo() {
        return new JavaVideo();
    }
}
