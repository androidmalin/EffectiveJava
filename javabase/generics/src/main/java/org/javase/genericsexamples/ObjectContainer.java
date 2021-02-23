package org.javase.genericsexamples;

/**
 * Object Container
 * 虽然这个容器会达到预期效果，但就我们的目的而言，它并不是最合适的解决方案。
 * 它不是类型安全的，并且要求在检索封装对象时使用显式类型转换，因此有可能引发异常。
 *
 * @author Juneau
 */
public class ObjectContainer {
    private Object obj;

    /**
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

}
