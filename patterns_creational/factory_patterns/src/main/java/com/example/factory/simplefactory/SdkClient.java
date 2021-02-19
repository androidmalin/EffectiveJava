package com.example.factory.simplefactory;

import java.util.Calendar;
import java.util.Date;

public class SdkClient {

    public static void main(String[] args) {
        jdk();
    }

    private static void jdk() {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println(time);
    }
}
