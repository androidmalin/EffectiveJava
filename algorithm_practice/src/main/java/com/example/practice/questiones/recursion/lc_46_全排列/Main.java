package com.example.practice.questiones.recursion.lc_46_全排列;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(array);
        System.out.println(permute);
    }
}
