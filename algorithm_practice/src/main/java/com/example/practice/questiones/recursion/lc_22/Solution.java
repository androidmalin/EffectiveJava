package com.example.practice.questiones.recursion.lc_22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 输入: n = 3
     * 输出: ["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * 示例 2:
     * <p>
     * 输入: n = 1
     * 输出: ["()"]
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //n
        _gen("", n, n, result);
        return result;
    }

    private void _gen(String subString, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(subString);
        }
        if (left > 0) {
            _gen(subString + "(", left - 1, right, result);
        }
        if (right > left) {
            _gen(subString + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
}
