package com.example.interpreter.calculate;

import java.util.Stack;


public class GPCalculator {
    private final Stack<IArithmeticInterpreter> stack = new Stack<>();

    public GPCalculator(String expression) {
        parse(expression);
    }

    //  10 + 30
    private void parse(String expression) {
        String[] elements = expression.split(" ");
        IArithmeticInterpreter left, right;
        for (int i = 0; i < elements.length; i++) {
            String operator = elements[i];
            if (OperatorUtil.isOperator(operator)) {
                left = this.stack.pop();
                right = new NumInterpreter(Integer.parseInt(elements[++i]));
                System.out.println("出栈" + left.interpret() + "和" + right.interpret());
                this.stack.push(OperatorUtil.getInterpreter(left, right, operator));
                System.out.println("应用运算符：" + operator);
            } else {
                NumInterpreter numInterpreter = new NumInterpreter(Integer.parseInt(elements[i]));
                this.stack.push(numInterpreter);
                System.out.println("入栈：" + numInterpreter.interpret());
            }

        }
    }

    public int calculate() {
        return this.stack.pop().interpret();
    }
}
