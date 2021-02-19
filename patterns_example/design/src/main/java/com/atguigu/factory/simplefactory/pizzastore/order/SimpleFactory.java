package com.atguigu.factory.simplefactory.pizzastore.order;

import com.atguigu.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.atguigu.factory.simplefactory.pizzastore.pizza.Pizza;

//简单工厂类
public class SimpleFactory {

    //更加orderType 返回对应的Pizza 对象
    public Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        return getPizza(orderType);
    }

    //简单工厂模式 也叫 静态工厂模式
    public static Pizza createPizza2(String orderType) {
        System.out.println("使用简单工厂模式2");
        return getPizza(orderType);
    }

    private static Pizza getPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "greek":
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
                break;
            case "cheese":
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
                break;
            case "pepper":
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
                break;
        }
        return pizza;
    }
}
