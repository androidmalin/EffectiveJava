package com.example.interpreter.calculate;


public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
    }

    public static Interpreter getInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right, String symbol) {
        switch (symbol) {
            case "+": {
                return new AddInterpreter(left, right);
            }
            case "-": {
                return new SubInterpreter(left, right);
            }
            case "*": {
                return new MultiplicationInterpreter(left, right);
            }
            case "/": {
                return new DivInterpreter(left, right);
            }
            default: {
                return null;
            }
        }
    }
}
