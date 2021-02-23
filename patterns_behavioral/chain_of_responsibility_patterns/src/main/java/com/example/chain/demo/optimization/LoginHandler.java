package com.example.chain.demo.optimization;

import com.example.chain.demo.bean.Member;

public class LoginHandler extends Handler {

    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
