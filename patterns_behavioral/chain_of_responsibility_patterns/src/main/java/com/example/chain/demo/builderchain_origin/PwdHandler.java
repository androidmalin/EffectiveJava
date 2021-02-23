package com.example.chain.demo.builderchain_origin;

import com.example.chain.demo.bean.Member;

public class PwdHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if (member.getLoginPass().length() < 3) {
            System.err.println("密码长度小于3");
            return;
        }
        System.out.println("密码长度符合要求");
        next.doHandler(member);
    }
}
