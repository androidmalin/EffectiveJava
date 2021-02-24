package com.example.specification.common;

/**
 * 组合规格书
 */
public abstract class CompositeSpecification implements ISpecification {
    /**
     * 是否满足条件由子类实现
     */
    @Override
    public abstract boolean isSatisfiedBy(Object candidate);

    /**
     * and操作
     */
    @Override
    public ISpecification and(ISpecification spec) {
        return new AndSpecification(this, spec);
    }

    /**
     * or操作
     */
    @Override
    public ISpecification or(ISpecification spec) {
        return new OrSpecification(this, spec);
    }

    /**
     * not操作
     */
    @Override
    public ISpecification not() {
        return new NotSpecification(this);
    }
}