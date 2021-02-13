package com.atguigu.command;

public class RemoteController {

    // 开 按钮的命令数组
    private final ICommand[] onICommands;
    private final ICommand[] offICommands;

    // 执行撤销的命令
    private ICommand undoICommand;

    // 构造器，完成对按钮初始化
    public RemoteController() {
        onICommands = new ICommand[5];
        offICommands = new ICommand[5];
        for (int i = 0; i < 5; i++) {
            onICommands[i] = new NoCommand();
            offICommands[i] = new NoCommand();
        }
    }

    // 给我们的按钮设置你需要的命令
    public void setCommand(int no, ICommand onICommand, ICommand offICommand) {
        onICommands[no] = onICommand;
        offICommands[no] = offICommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int no) { // no 0
        // 找到你按下的开的按钮， 并调用对应方法
        onICommands[no].execute();
        // 记录这次的操作，用于撤销
        undoICommand = onICommands[no];
    }

    // 按下开按钮
    public void offButtonWasPushed(int no) { // no 0
        // 找到你按下的关的按钮， 并调用对应方法
        offICommands[no].execute();
        // 记录这次的操作，用于撤销
        undoICommand = offICommands[no];
    }

    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undoICommand.undo();
    }
}
