package com.atguigu.factory.simplefactory.pizzastore.order;

import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    // 构造器
//    public OrderPizza() {
//        Pizza pizza;
//        String orderType; // 订购披萨的类型
//        orderType = getType();
//        switch (orderType) {
//            case "greek":
//                pizza = new GreekPizza();
//                pizza.setName(" 希腊披萨 ");
//                break;
//            case "cheese":
//                pizza = new CheesePizza();
//                pizza.setName(" 奶酪披萨 ");
//                break;
//            default:
//            case "pepper":
//                pizza = new PepperPizza();
//                pizza.setName("胡椒披萨");
//                break;
//        }
//        //输出pizza 制作过程
//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//    }

    //构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        //定义一个简单工厂对象
        String orderType = getType();//用户输入的
        Pizza pizza = simpleFactory.createPizza(orderType);
        //输出pizza
        if (pizza != null) { //订购成功
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println(" 订购披萨失败 ");
        }
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
