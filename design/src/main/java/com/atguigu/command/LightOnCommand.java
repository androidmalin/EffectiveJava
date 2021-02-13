package com.atguigu.command;

public class LightOnCommand implements ICommand {

    //聚合LightReceiver
    private final LightReceiver light = new LightReceiver();

    //构造器
    public LightOnCommand() {
        super();
    }

    @Override
    public void execute() {
        //调用接收者的方法
        light.on();
    }


    @Override
    public void undo() {
        //调用接收者的方法
        light.off();
    }

}
