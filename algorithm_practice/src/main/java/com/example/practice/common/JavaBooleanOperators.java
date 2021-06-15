package com.example.practice.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.freejavaguide.com/boolean_operators.htm
 */
@SuppressWarnings("all")
public class JavaBooleanOperators {

    /**
     * ^ the XOR operator
     * 不同为true
     * 相同为false
     * <p>
     * A      B      A^B
     * false  false   false
     * true   false   true
     * false  true    true
     * true   true    false
     */
    @Test
    public void xor() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true ^ false = " + (left1 ^ left2));
        Assertions.assertTrue((left1 ^ left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false ^ true = " + (left3 ^ left4));
        Assertions.assertTrue((left3 ^ left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        Assertions.assertFalse((left5 ^ left6));
        System.out.println("true ^ true = " + (left5 ^ left6));

        boolean left7 = false;
        boolean left8 = false;
        Assertions.assertFalse((left7 ^ left8));
        System.out.println("false ^ false = " + (left7 ^ left8));
        System.out.println(" ");
    }


    /**
     * | the OR operator
     * <p>
     * 有一个为true,则为true
     * <p>
     * true | false = true
     * false | true = true
     * <p>
     * true | true = true
     * false | false = false
     */
    @Test
    public void or() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true | false = " + (left1 | left2));
        Assertions.assertTrue((left1 | left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false | true = " + (left3 | left4));
        Assertions.assertTrue((left3 | left4));

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true | true = " + (left5 | left6));
        Assertions.assertTrue((left5 | left6));
        System.out.println(" ");

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false | false = " + (left7 | left8));
        Assertions.assertFalse((left7 | left8));
        System.out.println(" ");
    }

    /**
     * the short-circuit OR operator
     * <p>
     * 有一个为true,则为true
     * <p>
     * true || false = true
     * false || true = true
     * <p>
     * true || true = true
     * false || false = false
     */
    @Test
    public void short_circuit_or() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true || false = " + (left1 || left2));
        Assertions.assertTrue((left1 | left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false || true = " + (left3 || left4));
        Assertions.assertTrue((left3 || left4));

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true || true = " + (left5 || left6));
        Assertions.assertTrue((left5 || left6));
        System.out.println(" ");

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false || false = " + (left7 || left8));
        Assertions.assertFalse((left7 || left8));
        System.out.println(" ");
    }

    /**
     * & the AND operator
     * <p>
     * 两个都为true,才是true,其他都是false
     * <p>
     * true  & false = false
     * false & true  = false
     * true  & true  = true
     * false & false = false
     */
    @Test
    public void and() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true & false = " + (left1 & left2));
        Assertions.assertTrue((left1 || left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false & true = " + (left3 & left4));
        Assertions.assertTrue((left3 || left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true & true = " + (left5 & left6));
        Assertions.assertTrue((left5 || left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false & false = " + (left7 & left8));
        Assertions.assertFalse((left7 || left8));
        System.out.println(" ");
    }

    /**
     * && the short-circuit AND operator
     * <p>
     * true  && false = false
     * false && true  = false
     * true  && true  = true
     * false && false = false
     */
    @Test
    public void short_circuit_and() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true && false = " + (left1 && left2));
        Assertions.assertTrue((left1 || left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false && true = " + (left3 && left4));
        Assertions.assertTrue((left3 || left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true && true = " + (left5 && left6));
        Assertions.assertTrue((left5 || left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false && false = " + (left7 && left8));
        Assertions.assertFalse((left7 || left8));
        System.out.println(" ");
    }

}
