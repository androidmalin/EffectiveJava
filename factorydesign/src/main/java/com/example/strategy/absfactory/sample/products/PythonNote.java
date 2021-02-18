package com.example.strategy.absfactory.sample.products;

/**
 * Python笔记
 */
public class PythonNote implements INote {

    @Override
    public void edit() {
        System.out.println("编写Python笔记");
    }
}
