package com.atguigu.proxy.staticproxy;

//代理对象,静态代理
public class TeacherProxy implements ITeacher {

    private final ITeacher target; // 目标对象，通过接口来聚合

    //构造器
    public TeacherProxy(ITeacher target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理  完成某些操作。。。。。 ");//方法
        target.teach();
        System.out.println("提交。。。。。");//方法
    }
}
