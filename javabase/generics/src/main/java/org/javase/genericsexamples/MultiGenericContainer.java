package org.javase.genericsexamples;

/**
 * A Generic Container Implementation
 * <p>
 * 有时，能够在类或接口中使用多种泛型类型很有帮助。
 * 通过在尖括号之间放置一个逗号分隔的类型列表，可在类或接口中使用多个类型参数。
 * 以下的代码使用一个接受以下两种类型的类演示了此概念：T 和 S。
 * <p>
 * T 是第一种类型的标准标识符，S 是第二种类型的标准标识符。使用这两种类型生成一个使用泛型存储多个值的容器。
 *
 * @author Juneau
 */
public class MultiGenericContainer<T, S> {
    private T firstPosition;
    private S secondPosition;

    public MultiGenericContainer(T firstPosition, S secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    public MultiGenericContainer() {
    }

    public T getFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(T firstPosition) {
        this.firstPosition = firstPosition;
    }

    public S getSecondPosition() {
        return secondPosition;
    }

    public void setSecondPosition(S secondPosition) {
        this.secondPosition = secondPosition;
    }

}
