package com.example.servant;

/**
 * 雇工类
 * 雇工（Servant)：即执行者，用于执行服务。
 */
public class Servant {
    /**
     * 服务内容
     */
    public void service(IServiced serviceFuture) {
        serviceFuture.serviced();
    }
}