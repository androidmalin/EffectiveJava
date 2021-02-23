package com.example.visitor.kpi;

import java.util.Random;

public abstract class Employee {
    public String name;

    /**
     * 员工KPI
     */
    public int kpi;

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接收访问者的访问
    public abstract void accept(IVisitor visitor);
}
