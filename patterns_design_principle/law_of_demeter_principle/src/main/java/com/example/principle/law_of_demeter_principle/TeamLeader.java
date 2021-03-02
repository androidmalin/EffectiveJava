package com.example.principle.law_of_demeter_principle;

public class TeamLeader {
    public void commandCheckNumber(Employee employee) {
        employee.checkNumberOfCourses();
    }
}
