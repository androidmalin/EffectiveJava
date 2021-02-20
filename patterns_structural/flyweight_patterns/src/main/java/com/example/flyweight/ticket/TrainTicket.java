package com.example.flyweight.ticket;

import java.util.Random;


public class TrainTicket implements ITicket {
    private final String from;
    private final String to;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        int price = new Random().nextInt(500);
        System.out.println(from + "->" + to + ":" + bunk + "价格：" + price);
    }
}
