package com.example.practice.questiones.stack.lc_20_有效的括号;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    @Test
    public void test() {
        Solution2 solution = new Solution2();

        //1.
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid("}"));
        assertFalse(solution.isValid("]"));
        assertFalse(solution.isValid("[])"));

        //2.
        assertFalse(solution.isValid("(``)"));

        //3.
        assertFalse(solution.isValid("(){}}{"));
        assertFalse(solution.isValid("{[}"));
        assertFalse(solution.isValid("{[([)]}"));

        //4.
        assertTrue(solution.isValid("()"));
        assertTrue(solution.isValid("[]"));
        assertTrue(solution.isValid("{}"));
        assertTrue(solution.isValid("{[]}"));
    }
}