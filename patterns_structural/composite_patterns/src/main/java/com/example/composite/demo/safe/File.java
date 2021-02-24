package com.example.composite.demo.safe;


public class File extends Directory {
    public File(String name) {
        super(name);
    }

    public void show() {
        System.out.println(this.name);
    }
}
