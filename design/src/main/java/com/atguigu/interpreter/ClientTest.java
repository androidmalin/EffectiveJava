package com.atguigu.interpreter;

import java.io.IOException;
import java.util.HashMap;

public class ClientTest {

    public static void main(String[] args) throws IOException {
        String expStr = "a+b*c-d"; // a+b
        HashMap<String, Integer> var = new HashMap<>();// var {a=10, b=20}
        var.put("a", 1);
        var.put("b", 2);
        var.put("c", 5);
        var.put("d", 1);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }
}
