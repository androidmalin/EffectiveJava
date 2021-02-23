package com.example.visitor.common;

/**
 * 抽象访问者
 */
public interface IVisitor {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}