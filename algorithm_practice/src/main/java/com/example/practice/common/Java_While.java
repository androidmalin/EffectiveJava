package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java_While {


    /**
     * output
     * 1 0
     */
    @Test
    public void testI() {
        List<Integer> result = new ArrayList<>();
        int T = 2;
        //1. T=2,
        //2. 2>0
        //3. T=T-1 = 2-1=1
        //4. 进入循环体输入 T=1

        //1. T=1
        //2. 1>0
        //3. T=T-1 = 1-1=0
        //4. 进入循环体输入 T=0

        //1.T=0
        //2.0>0 false 结束
        while (T-- > 0) {
            result.add(T);
        }
        Assertions.assertTrue(ListUtil.isSame(Arrays.asList(1, 0), result));
    }

    /**
     * output
     * 1
     */
    @Test
    public void testI2() {
        List<Integer> result = new ArrayList<>();
        //1. T=2,
        //2. T=T-1 = 2-1=1
        //3. 1>0 true
        //3. 进入循环体输入 T=1

        //1. T=1,
        //2. T=T-1 = 1-1=0
        //3. 0>0 false 结束
        int T = 2;
        while (--T > 0) {
            result.add(T);
        }
        Assertions.assertTrue(ListUtil.isSame(Collections.singletonList(1), result));
    }

    /**
     * continue:结束本层的本次循环
     * output: 4 2 1 0
     */
    @Test
    public void test() {
        List<Integer> result = new ArrayList<>();
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                continue;
            }
            result.add(i);
        }
        Assertions.assertTrue(ListUtil.isSame(Arrays.asList(4, 2, 1, 0), result));
    }

    /**
     * 用于循环中
     * break:结束本层循环。
     * <p>
     * output: 4
     */
    @Test
    public void test2() {
        List<Integer> result = new ArrayList<>();
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                break;
            }
            result.add(i);
        }
        Assertions.assertTrue(ListUtil.isSame(Collections.singletonList(4), result));
    }


    /**
     * 用于循环中
     * return:
     * <p>
     * output: 4
     */
    @Test
    public void test3() {
        List<Integer> result = new ArrayList<>();
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                return;
            }
            result.add(i);
        }
        Assertions.assertTrue(ListUtil.isSame(Collections.singletonList(4), result));
    }


    /**
     * 用于循环中
     * break:结束本层循环。
     * output: 0 1 2
     */
    @Test
    public void breakTest1() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            result.add(i);
        }
        Assertions.assertTrue(ListUtil.isSame(Arrays.asList(0, 1, 2), result));
    }

    /**
     * 用于嵌套循环
     * break:结束本层循环。
     * output:
     * 0*0=0    0*1=0    0*2=0    0*3=0
     * 1*0=0    1*1=1    1*2=2    1*3=3
     * 2*0=0    break is executed!
     * 3*0=0    3*1=3    3*2=6    3*3=9
     */
    @Test
    public void breakTest2() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 2 && j == 1) {
                    System.out.print("break is executed!");
                    break;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
    }


    /**
     * continue:结束本层的本次循环
     * <p>
     * output: 0 1 2 4
     */
    @Test
    public void continueTest1() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    /**
     * continue:结束本层的本次循环
     * output:
     * 0*0=0    0*1=0    0*2=0    0*3=0
     * 1*0=0    1*1=1    1*2=2    1*3=3
     * 2*0=0    continue 2*2=4    2*3=6
     * 3*0=0    3*1=3    3*2=6    3*3=9
     */
    @Test
    public void continueTest2() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 2 && j == 1) {
                    System.out.print("continue" + " ");
                    continue;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
        System.out.println(" ");
    }


    /**
     * return:结束所有层的循环
     * output
     * 0 1 2
     */
    @Test
    public void returnTest1() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.println(" ");
                return;
            }
            System.out.print(i + " ");
        }
    }


    /**
     * return:结束所有层的循环
     * output:
     * 0*0=0    0*1=0    0*2=0    0*3=0
     * 1*0=0
     */
    @Test
    public void returnTest2() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 1 && j == 1) {
                    System.out.println(" ");
                    return;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
                result.add(i * j);
            }
            System.out.println();
        }
        Assertions.assertTrue(ListUtil.isSame(Arrays.asList(0, 0, 0, 0, 0), result));
    }
}