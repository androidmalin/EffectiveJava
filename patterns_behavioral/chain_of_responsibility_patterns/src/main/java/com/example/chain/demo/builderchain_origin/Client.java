package com.example.chain.demo.builderchain_origin;

public class Client {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("jake", "123");
    }
}
