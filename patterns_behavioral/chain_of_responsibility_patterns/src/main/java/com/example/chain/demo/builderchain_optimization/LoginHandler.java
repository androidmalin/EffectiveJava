package com.example.chain.demo.builderchain_optimization;

import com.example.chain.demo.bean.Member;

public class LoginHandler extends Handler<Member> {
    @Override
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
