package com.example.principle.law_of_demeter_principle;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public void checkNumberOfCourses() {
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量为：" + courseList.size());
    }
}
