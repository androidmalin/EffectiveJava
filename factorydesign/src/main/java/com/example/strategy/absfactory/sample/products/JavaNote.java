package com.example.strategy.absfactory.sample.products;

/**
 * Java笔记
 */
public class JavaNote implements INote {

    @Override
    public void edit() {
        System.out.println("编写Java笔记");
    }
}
