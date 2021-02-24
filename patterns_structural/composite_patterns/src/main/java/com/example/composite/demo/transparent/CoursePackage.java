package com.example.composite.demo.transparent;

import java.util.ArrayList;
import java.util.List;

public class CoursePackage extends CourseComponent {
    private final List<CourseComponent> items = new ArrayList<>();

    private final String name;
    private final Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent component) {
        items.add(component);
    }

    @Override
    public void removeChild(CourseComponent component) {
        items.remove(component);
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent c : items) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("   ");
                }
                for (int i = 0; i < this.level; i++) {
                    if (i == 0) {
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            c.print();
        }
    }
}
