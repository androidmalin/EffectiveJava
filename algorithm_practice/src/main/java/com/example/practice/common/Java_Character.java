package com.example.practice.common;

public class Java_Character {
    public static void main(String[] args) {
        String origin = "0123456789";
        char[] chars = origin.toCharArray();
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
