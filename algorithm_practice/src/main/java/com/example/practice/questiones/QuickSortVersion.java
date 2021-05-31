package com.example.practice.questiones;

import java.util.Arrays;

/**
 * https://www.bilibili.com/video/BV1HA411q7tH/?spm_id_from=333.788.videocard.2
 */
public class QuickSortVersion {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 7, 5, 6};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        subSort(array, 0, array.length - 1);
    }

    public static void subSort(int[] array, int low, int high) {
        // 选第一个元素作为pivot
        // 指针 i，指针 j 从第二个元素出发使得：
        // 指针 i 左边的都小于 pivot， 指针 i，指针 j 中间的（包括 i，j）都大于 pivot
        // j 指针比 i 跑得快，j 到达最后一个
        if (low < high) {
            int pivot = array[low];
            int i = low + 1;
            int j = low + 1;
            while (j <= high) {
                // 一开始 i,j 同步一直到第一个比 pivot 大的数出现，i 停下了
                if (array[j] < pivot) {
                    swap(array, i, j);
                    i++;
                }
                j++;
            }
            // 最后交换 pivot 和 第 i - 1 个
            swap(array, low, i - 1);
            // 递归调用左边右边
            subSort(array, low, i - 2);
            subSort(array, i, high);
        }
    }

    public static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}