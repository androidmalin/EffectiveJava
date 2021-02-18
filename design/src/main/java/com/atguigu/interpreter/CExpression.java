package com.atguigu.interpreter;

import java.util.HashMap;

public class CExpression extends SymbolExpression {

    public CExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) * super.right.interpreter(var);
    }
}
