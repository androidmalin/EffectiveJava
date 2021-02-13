package com.atguigu.template.improve;

public class PureSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        //空实现
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }

}
