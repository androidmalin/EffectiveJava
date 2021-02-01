package com.example.adapter.design.objectes;

public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();

    /**
     * 这是源类Adaptee没有的方法
     */
    void sampleOperation2();
}