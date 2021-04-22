package com.example.practice.common;

public class Java_While {

    public static void main(String[] args) {
        returnTest2();
        System.out.println(" ");
        breakTest2();
    }

    private static void test() {
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }

    private static void test2() {
        int i = 5;
        while (i-- > 0) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
    }


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
     * 用于循环
     * break:结束本层循环。
     */
    public static void breakTest2() {
        System.out.println("breakTest2 start");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 2 && j == 3) {
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
     */
    public static void continueTest2() {
        System.out.println("continueTest2 ");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 2 && j == 3) {
                    continue;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
        System.out.println(" ");
    }


    public static void returnTest1() {
        System.out.println("continueTest1 ");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                return;
            }
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }


    public static void returnTest2() {
        System.out.println("returnTest2 start ");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == 2 && j == 3) {
                    return;
                }
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
        System.out.println("returnTest2 end ");
    }
}