package com.example.factory.absfactory.demo;

public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
