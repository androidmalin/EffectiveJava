package com.example.principle.dependence_inversion_principle;

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
