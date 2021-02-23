package com.example.interpreter.calculate;

/**
 * 除法
 */
public class DivInterpreter extends Interpreter {
    public DivInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() / this.right.interpret();
    }
}
