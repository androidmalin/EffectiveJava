package com.example.chain.demo.builderchain_origin;

import com.example.chain.demo.bean.Member;

public class MemberService {

    public void login(String loginName, String loginPass) {
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new PwdHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(new Member(loginName, loginPass));
    }
}
