package com.example.command.common;

/**
 * 具体命令
 * 3.具体命令角色（ConcreteCommand）：该类内部维护一个Receiver,
 * 在其execute()方法中调用Receiver的相关方法。
 */
public class ConcreteCommand implements ICommand {
    /**
     * 直接创建接收者，不暴露给客户端
     */
    private final Receiver receiver = new Receiver();

    @Override
    public void execute() {
        this.receiver.action();
    }
}