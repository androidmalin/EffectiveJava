package com.example.adapter.classes;

/**
 * 这就是所期待得到的接口。
 * 注意：由于这里讨论的是类适配器模式
 */
public interface Target {
    /**
     * 这是源类(即被适配者)Adaptee也有的方法
     */
    void operation1();

    /**
     * 这是源类(即被适配者)Adaptee没有的方法
     */
    void operation2();
}