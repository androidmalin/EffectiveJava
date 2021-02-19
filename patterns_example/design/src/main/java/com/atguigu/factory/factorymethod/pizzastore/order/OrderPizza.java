package com.atguigu.factory.factorymethod.pizzastore.order;

import com.atguigu.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class OrderPizza {

    //定义一个抽象方法，createPizza , 让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    // 构造器
    public OrderPizza() {
        String orderType = getType();// 订购披萨的类型
        Pizza pizza = createPizza(orderType); //抽象方法，由工厂子类完成
        //输出pizza 制作过程
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }


    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            return strIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
