package com.atguigu.command;

public class LightOffCommand implements ICommand {

    /**
     * 聚合LightReceiver
     */
    private final LightReceiver light = new LightReceiver();

    public LightOffCommand() {
    }

    /**
     * 调用接收者的方法
     */
    @Override
    public void execute() {
        light.off();
    }

    /**
     * 调用接收者的方法
     */
    @Override
    public void undo() {
        light.on();
    }
}
