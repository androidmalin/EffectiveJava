package com.example.builder.chain;


public class Client {

    public static void main(String[] args) {
        CourseBuilder builder = new CourseBuilder()
                .addName("设计模式")
                .addPPT("PPT课件")
                .addVideo("录播视频")
                .addNote("note")
                .addHomework("homework");
        System.out.println(builder.build());
    }
}
