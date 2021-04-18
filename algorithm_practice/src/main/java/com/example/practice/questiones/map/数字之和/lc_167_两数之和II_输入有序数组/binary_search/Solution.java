package com.example.practice.questiones.map.数字之和.lc_167_两数之和II_输入有序数组.binary_search;

public class Solution {

    /**
     * 在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，然后寻找第二个数，
     * 第二个数等于目标值减去第一个数的差。
     * 利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
     * 为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找。
     * <p>
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/liang-shu-zhi-he-ii-shu-ru-you-xu-shu-zu-by-leet-2/
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
