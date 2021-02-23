package com.example.chain.demo.builderchain_optimization;

public class Client {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("tom", "666");
    }
}
