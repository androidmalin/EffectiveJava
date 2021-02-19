package com.atguigu.adapter.classadapter;

public class Phone {
    //充电
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为5V, 可以充电~~");
        } else {
            System.out.println("电压!=5V, 不能充电~~");
        }
    }
}
