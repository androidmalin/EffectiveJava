package com.example.singleton.register;


import java.io.Serializable;

public enum EnumSingleton implements Serializable {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
