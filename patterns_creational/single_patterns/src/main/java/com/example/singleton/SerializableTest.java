package com.example.singleton;


import com.example.singleton.lazy.LazyStaticInnerClassSingleton;
import com.example.singleton.register.EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * 另外一种情况，可能会遇到，我们需要将对象序列化到磁盘，下次使用时再从磁盘反序列化回来，
 * 反序列化的对象会被重新分配内存，那如果序列化的对象为单例，则就违背了单例模式的初衷。
 * 这也相当于破坏了单例。
 * <p>
 * 序列化
 * 把内存中对象的状态转换为字节码的形式
 * 把字节码通过IO输出流，写到磁盘上
 * 永久保存下来，持久化
 * <p>
 * 反序列化
 * 将持久化的字节码内容，通过IO输入流读到内存中来
 * 转化成一个Java对象
 */
public class SerializableTest {
    public static void main(String[] args) {
        testSerializable();
        catSerializableFileContent();
        testSerializable_LazyStaticInnerClassSingleton();
    }

    private static void testSerializable_LazyStaticInnerClassSingleton() {
        LazyStaticInnerClassSingleton s1;
        LazyStaticInnerClassSingleton s2 = LazyStaticInnerClassSingleton.getInstance();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("LazyStaticInnerClassSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("LazyStaticInnerClassSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (LazyStaticInnerClassSingleton) ois.readObject();
            ois.close();

            System.out.println(s1 == s2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void testSerializable() {
        EnumSingleton s1;
        EnumSingleton s2 = EnumSingleton.INSTANCE;
        FileOutputStream fos;
        try {
            fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(s1 == s2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * https://blog.csdn.net/lqzkcx3/article/details/79463450
     */
    private static void catSerializableFileContent() {
        try {
            //确定十六进制的书写方式
            String HEX = "0123456789ABCDEF";
            //字节byte读取
            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            //将文件数据读取到字节数组byte中,数组大小由fis的可读大小决定
            byte[] bytes = new byte[fis.available()];
            while (fis.read(bytes) != -1) {
                //将字节转化为十六进制
                for (byte b : bytes) {
                    //取字节的高四位,与0x0f与运算,得到该十六进制数据对应的索引(0~15)
                    System.out.print(HEX.charAt((b >> 4) & 0x0f));
                    //字节的低四位
                    System.out.print(HEX.charAt(b & 0x0f));
                    System.out.print(" ");//AC ED ......
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
