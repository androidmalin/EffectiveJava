package com.example.practice.questiones._true;

/**
 * 二维数组回形遍历
 */
public class PalindromeUtils {

    public static void palindrome(int[][] num) {
        int x = num.length;
        int y = num[0].length;
        int up = 0;
        int down = x - 1;
        int left = 0;
        int right = y - 1;
        while (true) {
            for (int i = left; i <= right; i++)//往右
            {
                System.out.println(num[up][i]);
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                System.out.println(num[i][right]);//xia
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                System.out.println(num[down][i]);
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                System.out.println(num[i][left]);
            }
            if (++left > right)
                break;
        }
    }

    public static void main(String[] args) {
        int[][] num = new int[3][3];
        num[0][0] = 1;
        num[0][1] = 2;
        num[0][2] = 3;
        num[1][0] = 4;
        num[1][1] = 5;
        num[1][2] = 6;
        num[2][0] = 7;
        num[2][1] = 8;
        num[2][2] = 9;
        palindrome(num);
    }
}
