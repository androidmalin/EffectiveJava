package com.example.practice.questiones.stack.lc_20_有效的括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution2 {

    public boolean isValid(String s) {
        //参数判断
        int length = s.length();
        if (length % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) return false;
                stack.poll();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
