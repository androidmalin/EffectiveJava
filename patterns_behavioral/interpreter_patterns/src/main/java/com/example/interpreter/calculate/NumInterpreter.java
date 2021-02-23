package com.example.interpreter.calculate;

/**
 * 终结表达式
 */
public class NumInterpreter implements IArithmeticInterpreter {
    private final int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
