package com.example.interpreter.calculate;

/**
 * 乘法
 */
public class MultiplicationInterpreter extends Interpreter {
    public MultiplicationInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() * this.right.interpret();
    }
}
