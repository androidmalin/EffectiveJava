package com.example.practice.questiones.stack.lc_20_有效的括号_map;

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
public class Solution {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    /**
     * addLast 然后 removeLast 是栈实现
     * <p>
     * "([])"
     * stack ( [
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else {
                if (map.get(stack.removeLast()) != c) {
                    return false;
                }
            }
        }
        return stack.size() == 1 && stack.peek().equals('?');
    }
}