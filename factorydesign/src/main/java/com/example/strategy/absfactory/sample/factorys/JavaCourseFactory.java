package com.example.strategy.absfactory.sample.factorys;

import com.example.strategy.absfactory.sample.products.INote;
import com.example.strategy.absfactory.sample.products.IVideo;
import com.example.strategy.absfactory.sample.products.JavaNote;
import com.example.strategy.absfactory.sample.products.JavaVideo;

public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        return new JavaNote();
    }

    public IVideo createVideo() {
        return new JavaVideo();
    }
}
