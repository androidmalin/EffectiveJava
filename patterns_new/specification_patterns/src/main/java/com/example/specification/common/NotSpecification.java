package com.example.specification.common;

public class NotSpecification extends CompositeSpecification {
    /**
     * 传递一个规格书进行not操作
     */
    private final ISpecification spec;

    public NotSpecification(ISpecification spec) {
        this.spec = spec;
    }

    /**
     * 进行not运算
     */
    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return !spec.isSatisfiedBy(candidate);
    }
}