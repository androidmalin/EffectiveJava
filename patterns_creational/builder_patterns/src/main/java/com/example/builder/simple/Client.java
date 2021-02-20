package com.example.builder.simple;


public class Client {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder();
        builder.addName("设计模式");
        builder.addPPT("PPT课件");
        builder.addVideo("录播视频");
        builder.addNote("笔记");
        builder.addHomework("作业");
        System.out.println(builder.build());
    }
}
