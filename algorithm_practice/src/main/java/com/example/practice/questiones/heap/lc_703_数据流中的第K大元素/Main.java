package com.example.practice.questiones.heap.lc_703_数据流中的第K大元素;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{
                4, 5, 8, 2
        };
        KthLargest kthLargest = new KthLargest(3, array);
        System.out.println("======");
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
//        System.out.println("kthLargest.add(3):" + kthLargest.add(3));
//        System.out.println("kthLargest.add(5):" + kthLargest.add(5));
//        System.out.println("kthLargest.add(10):" + kthLargest.add(10));
//        System.out.println("kthLargest.add(9):" + kthLargest.add(9));
//        System.out.println("kthLargest.add(4):" + kthLargest.add(4));
        //4, 5, 8, 2   3个
        //① 4,5,8   add(3) => 4,5,8  => 4
        //② 4,5,8   add(5) => 5,5,8  => 5
        //③ 5,5,8   add(10)=> 5,8,10 => 5
        //④ 5,8,10  add(9) => 8,9,10 => 8
        //⑤ 8,9,10  add(4) => 8,9,10 => 8
    }

    @Test
    public void test() {
        int[] array = new int[]{
                4, 5, 8, 2
        };
        KthLargest kthLargest = new KthLargest(3, array);
        Assertions.assertEquals(4, kthLargest.add(3));
        Assertions.assertEquals(5, kthLargest.add(5));
        Assertions.assertEquals(5, kthLargest.add(10));
        Assertions.assertEquals(8, kthLargest.add(9));
        Assertions.assertEquals(8, kthLargest.add(4));
    }
}
