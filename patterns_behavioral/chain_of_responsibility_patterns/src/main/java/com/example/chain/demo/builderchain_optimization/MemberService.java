package com.example.chain.demo.builderchain_optimization;

import com.example.chain.demo.bean.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder<Member> builder = new Handler.Builder<>();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(new Member(loginName, loginPass));
    }
}
