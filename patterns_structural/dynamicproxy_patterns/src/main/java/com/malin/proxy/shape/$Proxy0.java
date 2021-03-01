package com.malin.proxy.shape;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class $Proxy0 extends Proxy implements IShape {

    private static final Method toStringMethod;
    private static final Method hashCodeMethod;
    private static final Method equalMethod;
    private static final Method drawMethod;

    static {
        try {
            // public boolean equals(Object obj) {
            //        return (this == obj);
            //    }
            Class<?> objectClazz = Class.forName("java.lang.Object");
            Class<?> iShapeClazz = Class.forName("com.malin.proxy.shape.IShape");
            toStringMethod = objectClazz.getMethod("toString");
            hashCodeMethod = objectClazz.getMethod("hashCode");
            equalMethod = objectClazz.getMethod("equals", objectClazz);
            drawMethod = iShapeClazz.getMethod("draw");

            toStringMethod.setAccessible(true);
            hashCodeMethod.setAccessible(true);
            equalMethod.setAccessible(true);
            drawMethod.setAccessible(true);
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param handler the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},is {@code null}.
     */
    protected $Proxy0(InvocationHandler handler) {
        super(handler);
    }


    @Override
    public final void draw() {
        try {
            super.h.invoke(this, drawMethod, null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }


    @Override
    public final boolean equals(Object var1) {
        try {
            return (Boolean) super.h.invoke(this, equalMethod, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String toString() {
        try {
            return (String) super.h.invoke(this, toStringMethod, null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final int hashCode() {
        try {
            return (Integer) super.h.invoke(this, hashCodeMethod, null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }
}
