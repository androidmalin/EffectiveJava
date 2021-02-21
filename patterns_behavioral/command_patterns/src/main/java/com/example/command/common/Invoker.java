package com.example.command.common;

/**
 * 请求者
 * <p>
 * 4.请求者角色(Invoker)：接收客户端的命令，并执行命令。
 */
public class Invoker {
    private final ICommand cmd;

    public Invoker(ICommand cmd) {
        this.cmd = cmd;
    }

    public void action() {
        this.cmd.execute();
    }
}