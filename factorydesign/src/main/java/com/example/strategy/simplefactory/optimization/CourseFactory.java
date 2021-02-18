package com.example.strategy.simplefactory.optimization;

public class CourseFactory {

    public static ICourse create(Class<? extends ICourse> clazz) {
        ICourse iCourse = null;
        try {
            iCourse = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return iCourse;
    }

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
