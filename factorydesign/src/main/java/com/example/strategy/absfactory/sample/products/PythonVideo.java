package com.example.strategy.absfactory.sample.products;

public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
