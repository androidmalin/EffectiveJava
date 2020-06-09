package org.javase.genericsexamples;

/**
 * 有界类型
 * 我们经常会遇到这种情况，需要指定泛型类型，但希望控制可以指定的类型，而非不加限制。
 * 有界类型 在类型参数部分指定 extends 或 super 关键字，分别用上限或下限限制类型，从而限制泛型类型的边界。
 * 例如，如果希望将某类型限制为特定类型或特定类型的子类型，请使用以下表示法：
 * <T extends UpperBoundType>
 * <p>
 * 同样，如果希望将某个类型限制为特定类型或特定类型的超类型，请使用以下表示法：
 * <T super LowerBoundType>
 * <p>
 * 在以下示例中，我们用先前使用的 GenericNumberContainer 类，通过指定一个上限，将其泛型类型限制为 Number 或 Number 的子类。
 * 注意，GenericNumberContainer 这个新类指定泛型类型必须扩展 Number 类型。
 *
 * @author Juneau
 */
public class GenericNumberContainer<T extends Number> {
    private T obj;

    public GenericNumberContainer() {
    }

    public GenericNumberContainer(T t) {
        obj = t;
    }

    /**
     * set
     *
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * set
     *
     * @param t the obj to set
     */
    public void setObj(T t) {
        obj = t;
    }
}

