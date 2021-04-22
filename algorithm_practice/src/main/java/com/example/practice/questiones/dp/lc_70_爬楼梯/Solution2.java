package com.example.practice.questiones.dp.lc_70_爬楼梯;

public class Solution2 {
    /**
     * 1、每次你可以爬 1 或 2 个台阶。 2、不能连续跳两个台阶。
     * （个人理解为这次跳了两个台阶，下次不能再跳两个台阶）
     * <p>
     * 题目里“不能连续跳两个台阶”，即一旦跳了两个台阶，则下一步只能跳一步（2->1），
     * 把它们连在一起就一共跳了三个台阶，
     * <p>
     * 所以问题可以转化为要么跳一个台阶，要么跳三个台阶
     * （当然还是有点区别的，只不过因为结果是一样的，所以可以这么转化），
     * 于是就有了 f(x) = f(x-1) + f(x-3)
     */
    public int climbStarts2(int n) {
        if (n <= 1) return 1; // 防止数组溢出（f[2]）
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }
}
