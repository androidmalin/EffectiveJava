package com.example.mvc.dependency_injection.common;

/**
 * 依赖注入的类型
 * 客户端对象至少可以通过三种方式来接收对外部模块的引用
 * <p>
 * 1.构造函数注入
 * 依赖关系是通过客户端的类构造函数提供的。
 * <p>
 * 2.setter()方法注入
 * 客户端公开注入器用来注入依赖项的setter方法。
 * <p>
 * 3.接口注入
 * 依赖项的接口提供了一个注入器方法，可以将依赖项注入到传递给它的任何客户端中。
 * 客户端必须实现一个接口，该接口公开一个接受依赖项的setter方法。
 */
public class Client {
    public static void main(String[] args) {

    }
}
