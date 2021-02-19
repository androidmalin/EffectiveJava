package com.example.factory.simplefactory.optimization;

public class CourseFactory {

    public static ICourse create(String type) {
        ICourse iCourse;
        switch (type) {
            case "java": {
                iCourse = new JavaCourse();
                break;
            }
            case "python": {
                iCourse = new PythonCourse();
                break;
            }
            default: {
                throw new IllegalStateException("Unexpected value: " + type);
            }
        }
        return iCourse;
    }
}
