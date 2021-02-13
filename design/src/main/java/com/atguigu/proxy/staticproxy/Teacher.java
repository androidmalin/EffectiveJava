package com.atguigu.proxy.staticproxy;

public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println(" 老师授课中  。。。。。");
    }
}
