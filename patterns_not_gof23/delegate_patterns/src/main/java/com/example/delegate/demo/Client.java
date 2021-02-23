package com.example.delegate.demo;


public class Client {
    public static void main(String[] args) {
        new Boss().command("海报图", new Leader());
        new Boss().command("爬虫", new Leader());
        new Boss().command("卖手机", new Leader());
    }
}
