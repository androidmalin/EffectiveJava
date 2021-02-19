package com.atguigu.decorator;

public abstract class Drink {
    /**
     * 描述
     */
    public String description;
    private float price = 0.0f;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 计算费用的抽象方法
     * 子类来实现
     */
    public abstract float cost();

}
