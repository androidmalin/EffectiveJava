package com.example.practice.common;

public class Java_While {

    public static void main(String[] args) {
        testI();
    }


    /**
     * output
     * 1 0
     */
    private static void testI() {
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
            System.out.print(T + " ");
        }
        System.out.println();
    }

    /**
     * output
     * 1
     */
    private static void testI2() {
        //1. T=2,
        //2. T=T-1 = 2-1=1
        //3. 1>0 true
        //3. 进入循环体输入 T=1

        //1. T=1,
        //2. T=T-1 = 1-1=0
        //3. 0>0 false 结束
        int T = 2;
        while (--T > 0) {
            System.out.print(T + " ");
        }
        System.out.println();
    }

    /**
     * continue:结束本层的本次循环
     * output: 4 2 1 0
     */
    private static void test() {
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    /**
     * 用于循环中
     * break:结束本层循环。
     * <p>
     * output: 4 2 1 0
     */
    private static void test2() {
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
    }


    /**
     * 用于循环中
     * return:
     * <p>
     * output: 4
     */
    private static void test3() {
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                return;
            }
            System.out.println(i);
        }
    }


    /**
     * 用于循环中
     * break:结束本层循环。
     * output: 0 1 2
     */
    public static void breakTest1() {
        System.out.println("breakTest1 ");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    /**
     * 用于嵌套循环
     * break:结束本层循环。
     * output:
     * 0*0=0    0*1=0    0*2=0    0*3=0    0*4=0
     * 1*0=0    1*1=1    1*2=2    1*3=3    1*4=4
     * 2*0=0    break is executed!
     * 3*0=0    3*1=3    3*2=6    3*3=9    3*4=12
     * 4*0=0    4*1=4    4*2=8    4*3=12    4*4=16
     */
    public static void breakTest2() {
        System.out.println("breakTest2 start");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 2 && j == 1) {
                    System.out.print("break is executed!");
                    break;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
        System.out.println("breakTest2 end ");
    }


    /**
     * continue:结束本层的本次循环
     * <p>
     * output: 0 1 2 4
     */
    public static void continueTest1() {
        System.out.println("continueTest1 ");
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
     * 0*0=0    0*1=0    0*2=0    0*3=0    0*4=0
     * 1*0=0    1*1=1    1*2=2    1*3=3    1*4=4
     * 2*0=0    continue 2*2=4    2*3=6    2*4=8
     * 3*0=0    3*1=3    3*2=6    3*3=9    3*4=12
     * 4*0=0    4*1=4    4*2=8    4*3=12    4*4=16
     */
    public static void continueTest2() {
        System.out.println("continueTest2 ");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
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
    public static void returnTest1() {
        System.out.println("returnTest1 ");
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
     * 0*0=0    0*1=0    0*2=0    0*3=0    0*4=0
     * 1*0=0
     */
    public static void returnTest2() {
        System.out.println("returnTest2");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 1 && j == 1) {
                    System.out.println(" ");
                    return;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
    }
}