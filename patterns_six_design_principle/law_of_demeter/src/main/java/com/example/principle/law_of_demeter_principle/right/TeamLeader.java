package com.example.principle.law_of_demeter_principle.right;

public class TeamLeader {
    public void commandCheckNumber(Employee employee) {
        employee.checkNumberOfCourses();
    }
}
