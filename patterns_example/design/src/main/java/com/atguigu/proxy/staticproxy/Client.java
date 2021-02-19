package com.atguigu.proxy.staticproxy;

public class Client {

    public static void main(String[] args) {

        //创建目标对象(被代理对象)
        Teacher teacherDao = new Teacher();

        //创建代理对象, 同时将被代理对象传递给代理对象
        TeacherProxy teacherDaoProxy = new TeacherProxy(teacherDao);

        //通过代理对象，调用到被代理对象的方法
        //即：执行的是代理对象的方法，代理对象再去调用目标对象的方法
        teacherDaoProxy.teach();
    }

}
