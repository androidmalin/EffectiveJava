package com.example.practice.questiones._true.二维数组回形遍历;

import org.junit.jupiter.api.Test;

/**
 * 二维数组回形遍历
 * http://noi.openjudge.cn/ch0108/23/
 * <p>
 * 来源
 * 北京大学2009年医学部练习题
 */
public class Solution {

    /**
     * 思路：设置一个变量表示打印到了第几层，在每一轮中分别打印 上、右、下、上，
     * 并统计打印的字符的数量，当打印的数量与数据总量相等的时候，程序退出
     */
    public void palindrome(int[][] num) {
        int x = num.length;
        int y = num[0].length;
        int up = 0;
        int down = x - 1;
        int left = 0;
        int right = y - 1;
        while (true) {
            for (int i = left; i <= right; i++) {//往右
                System.out.println(num[up][i]);
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                System.out.println(num[i][right]);//xia
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                System.out.println(num[down][i]);
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                System.out.println(num[i][left]);
            }
            if (++left > right) break;
        }
    }

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */
    @Test
    public void main() {
        Solution solution = new Solution();
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
        solution.palindrome(num);
    }
}
