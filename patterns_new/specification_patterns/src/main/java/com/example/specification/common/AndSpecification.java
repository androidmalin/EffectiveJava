package com.example.specification.common;

/**
 * 与规格书
 */
public class AndSpecification extends CompositeSpecification {

    /**
     * 传递两个规格书进行and操作
     */
    private final ISpecification left;
    private final ISpecification right;

    public AndSpecification(ISpecification left, ISpecification right) {
        this.left = left;
        this.right = right;
    }

    /**
     * 进行and运算
     */
    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return left.isSatisfiedBy(candidate) && right.isSatisfiedBy(candidate);
    }
}