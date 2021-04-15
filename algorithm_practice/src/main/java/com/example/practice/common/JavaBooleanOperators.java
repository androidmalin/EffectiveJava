package com.example.practice.common;

public class JavaBooleanOperators {


    /**
     * https://www.freejavaguide.com/boolean_operators.htm
     */
    public static void main(String[] args) {
        or();
        short_circuit_or();

        and();
        short_circuit_and();

        xor();
    }


    /**
     * ^ the XOR operator
     * <p>
     * A      B      A^B
     * false  false   false
     * true   false   true
     * false  true    true
     * true   true    false
     */
    private static void xor() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true ^ false = " + (left1 ^ left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false ^ true = " + (left3 ^ left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true ^ true = " + (left5 ^ left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false ^ false = " + (left7 ^ left8));
        System.out.println(" ");
    }


    /**
     * | the OR operator
     * <p>
     * true | false = true
     * false | true = true
     * <p>
     * true | true = true
     * false | false = false
     */
    private static void or() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true | false = " + (left1 | left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false | true = " + (left3 | left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true | true = " + (left5 | left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false | false = " + (left7 | left8));
        System.out.println(" ");
    }

    /**
     * the short-circuit OR operator
     * true || false = true
     * false || true = true
     * <p>
     * true || true = true
     * false || false = false
     */
    private static void short_circuit_or() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true || false = " + (left1 || left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false || true = " + (left3 || left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true || true = " + (left5 || left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false || false = " + (left7 || left8));
        System.out.println(" ");
    }

    /**
     * & the AND operator
     * <p>
     */
    private static void and() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true & false = " + (left1 & left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false & true = " + (left3 & left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true & true = " + (left5 & left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false & false = " + (left7 & left8));
        System.out.println(" ");
    }

    /**
     * && the short-circuit AND operator
     */
    private static void short_circuit_and() {
        boolean left1 = true;
        boolean left2 = false;
        System.out.println("true && false = " + (left1 && left2));

        boolean left3 = false;
        boolean left4 = true;
        System.out.println("false && true = " + (left3 && left4));
        System.out.println(" ");

        boolean left5 = true;
        boolean left6 = true;
        System.out.println("true && true = " + (left5 && left6));

        boolean left7 = false;
        boolean left8 = false;
        System.out.println("false && false = " + (left7 && left8));
        System.out.println(" ");
    }

}
