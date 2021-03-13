package com.example.interfaceabs.demo.interfaceClazz;

import com.example.interfaceabs.demo.Bean;

public class Main {

    public static void main(String[] args) {
        Bean bean = DealWithHandle.<Bean>handle(new DealWithHandle.Fun<Bean>() {
            @Override
            public String firstFunction() {
                return "Java";
            }

            @Override
            public String secondFunction(String requestText) {
                return requestText.toLowerCase();
            }

            @Override
            public Bean thirdFunction(String responseText) {
                return new Bean(responseText);
            }
        });
        System.out.println(bean);
    }

}
