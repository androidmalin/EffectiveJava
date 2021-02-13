package com.atguigu.proxy.cglib;

public class Client {

    public static void main(String[] args) {

        //创建目标对象
        Teacher target = new Teacher();
        //获取到代理对象，并且将目标对象传递给代理对象
        Teacher proxyInstance = (Teacher) new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法，触发intercept 方法，从而实现 对目标对象的调用
        String res = proxyInstance.teach();
        System.out.println("res=" + res);
    }

}
