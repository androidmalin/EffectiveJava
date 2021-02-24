package com.example.specification.common;

public class OrSpecification extends CompositeSpecification {
    /**
     * 传递两个规格书进行or操作
     */
    private final ISpecification left;
    private final ISpecification right;

    public OrSpecification(ISpecification left, ISpecification right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 进行or运算
     */
    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return left.isSatisfiedBy(candidate) || right.isSatisfiedBy(candidate);
    }
}