package com.example.nullobj;

//对象工厂
public class ObjectFactory {
    private static final String[] NAMES_ARRAY = {"Tom", "Mic", "James"};

    public AbstractObject getObject(String nickName) {
        for (String name : NAMES_ARRAY) {
            if (name.equalsIgnoreCase(nickName)) {
                return new RealObject(name);
            }
        }
        return new NullObject();
    }
}