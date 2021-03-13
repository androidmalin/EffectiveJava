package com.example.interfaceabs.demo.absClass;

import com.example.interfaceabs.demo.Bean;

public class Main {
    public static void main(String[] args) {
        fun0();
        fun();
    }

    private static void fun0() {
        Common common = new Common();
        Bean bean = common.handle();
        System.out.println(bean);
    }

    private static void fun() {
        Template<Bean> template = new Template<Bean>() {
            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String request) {
                return request.toLowerCase();
            }

            @Override
            public Bean thirdFunction(String responseText) {
                return new Bean(responseText);
            }
        };
        Bean bean = template.handle();
        System.out.println(bean);
    }
}
