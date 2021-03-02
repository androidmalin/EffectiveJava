package com.example.principle.dependence_inversion_principle;

import com.example.principle.ICourse;

public class Tom {

    private ICourse iCourse;

    //DI
    public void setICourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study() {
        iCourse.study();
    }
}
