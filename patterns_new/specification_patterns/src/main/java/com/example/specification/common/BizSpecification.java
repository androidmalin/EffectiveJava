package com.example.specification.common;

/**
 * 业务规格书
 */
public class BizSpecification extends CompositeSpecification {
    /**
     * 基准对象，如姓名等，也可以是int等类型
     */
    private final String obj;

    public BizSpecification(String obj) {
        this.obj = obj;
    }

    /**
     * 判断是否满足要求
     */
    @Override
    public boolean isSatisfiedBy(Object candidate) {
        //根据基准对象判断是否符合
        return true;
    }


    @Override
    public String toString() {
        return "BizSpecification{" +
                "obj='" + obj + '\'' +
                '}';
    }
}