package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Java_String {

    /**
     * Java 中字符串处理函数 substring。
     * <p>
     * 第一个参数应该：
     * >=0
     * <= s.length()
     * <p>
     * 第二个参数应该：
     * >= 第一个参数
     * <= s.length()
     * <p>
     * 取值不包含第二个参数对应的字符。
     * <p>
     * 左闭右开
     * substring [)
     */
    @Test
    public void test1() {
        String origin = "0123456789";
        String result = origin.substring(0, origin.lastIndexOf("9"));
        Assertions.assertEquals("012345678", result);
    }


    @Test
    public void test2() {
        String origin = "0123456789";
        String result = origin.substring(9);
        Assertions.assertEquals("9", result);
    }

    @Test
    public void test3() {
        String origin = "0123456789";
        String result = origin.substring(1);
        Assertions.assertEquals("123456789", result);
    }

    /**
     * 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * public int indexOf(int ch):
     * <p>
     * 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * public int indexOf(int ch, int fromIndex):
     * <p>
     * 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * int indexOf(String str):
     * <p>
     * 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * int indexOf(String str, int fromIndex):
     */
    @Test
    public void test4() {
        String origin = "01234567891";
        int result = origin.indexOf("1");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void test5() {
        String origin = "01234567891";
        int result = origin.lastIndexOf("1");
        Assertions.assertEquals(10, result);
    }


}
