package com.example.chain.demo.optimization;


public class Client {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("jake", "123");
    }
}
