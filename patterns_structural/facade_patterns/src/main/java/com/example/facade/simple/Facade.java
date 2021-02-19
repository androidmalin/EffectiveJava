package com.example.facade.simple;

/**
 * 外观角色 Facade
 */
public class Facade {
    private final SubSystemA subSystemA = new SubSystemA();
    private final SubSystemB subSystemB = new SubSystemB();
    private final SubSystemC subSystemC = new SubSystemC();

    /**
     * 对外接口
     */
    public void doA() {
        this.subSystemA.doA();
    }

    /**
     * 对外接口
     */
    public void doB() {
        this.subSystemB.doB();
    }

    /**
     * 对外接口
     */
    public void doC() {
        this.subSystemC.doC();
    }
}