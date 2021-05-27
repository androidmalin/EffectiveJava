package com.example.practice.questiones.stack.lc_20_有效的括号_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Solution2 {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {

        //TODO:5.27
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        boolean valid3 = solution.isValid("([])");
        System.out.println(valid3);
    }

}