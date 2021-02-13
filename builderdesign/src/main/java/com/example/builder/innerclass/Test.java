package com.example.builder.innerclass;

public class Test {
    public static void main(String[] args) {
        Course course = new Course.Builder()
                .addName("设计模式")
                .addPpt("【PPT课件】")
                .addVideo("【录播视频】")
                .builder();
        System.out.println(course);
    }
}
