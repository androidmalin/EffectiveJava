package com.atguigu.command;

//创建命令接口
public interface ICommand {
    //执行动作(操作)
    void execute();

    //撤销动作(操作)
    void undo();
}
