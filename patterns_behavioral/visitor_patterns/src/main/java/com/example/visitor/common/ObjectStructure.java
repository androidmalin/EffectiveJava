package com.example.visitor.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 */
public class ObjectStructure {
    private final List<IElement> list = new ArrayList<>();

    {
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    public void accept(IVisitor visitor) {
        for (IElement element : this.list) {
            element.accept(visitor);
        }
    }
}