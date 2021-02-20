package com.example.flyweight.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {

    private static final Map<String, ITicket> POOL = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to) {
        String key = from + "->" + to;
        if (POOL.containsKey(key)) {
            System.out.println("使用缓存" + key);
            return POOL.get(key);
        }
        System.out.println("首次查询，创建对象:" + key);
        ITicket ticket = new TrainTicket(from, to);
        POOL.put(key, ticket);
        return ticket;
    }
}
