package generics;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import generics.coffee.Coffee;
import generics.coffee.Latte;
import generics.coffee.Mocha;

import static net.mindview.util.Print.print;

interface Addable<T> {
    void add(T t);
}

// Using adapters to simulate latent typing.
public class Fill2 {
    // Class Token version:
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    // Generator version:
    @SuppressWarnings("unused")
    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++) {
            addable.add(generator.next());
        }

    }
}

/**
 * To adapt a base type, you must use composition.
 * Make any Collection Addable using composition:
 * <p>
 * AddableCollectionAdapter,可以工作于基类型Collection，
 * 这意味着Collection的任何实现都可以使用。这个版本直接存储Collection引用，
 * 并使用它来实现add().
 */
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> collection;

    public AddableCollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public void add(T item) {
        collection.add(item);
    }
}

/**
 * A Helper to capture the type automatically:
 * <p>
 * 这个泛化方法捕获类型并因此而不必显式地写出来
 * 这是产生更优雅的代码的一种惯用技巧。
 */
class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

/**
 * To adapt a specific type, you can use inheritance.
 * Make a SimpleQueue Addable using inheritance:
 * <p>
 * 如果有一个具体类型而不是继承结构的基类，那么当使用继承来创建适配器时，
 * 你可以稍微少编写一些代码，就像在AddableSimpleQueue中看到的那样。
 */
class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T item) {
        super.add(item);
    }
}

/**
 * 用适配器仿真潜在类型机制
 * Java泛型并不没有潜在类型机制，而我们需要像潜在类型机制这样的东西去
 * 编写能够跨类边界应用的代码（也就是"泛化"代码）。存在某种方式可以绕过这
 * 项限制吗？
 * 潜在类型机制将在这里实现什么？它意味着你可以编写代码声明：
 * "我不关心我在这里使用的类型，只要它具有这些方法即可。"
 * 实际上，潜在类型机制创建了一个包含所需方法的隐式接囗。
 * <p>
 * 因此它遵循这样的规则：如果我们手工编写了必需的接囗
 * （因为Java并没有为我们做这些事），那么它就应该能够解决问题。
 * <p>
 * 从我们拥有的接囗中编写代码来产生我们需要的接囗，这是适配器设计模式的一个典型示例。
 * 我们可以使用适配器来适配已有的接囗，以产生想要的接囗。
 * 下面这种使用前面定义的Coffee继承结构的解决方案演示了编写适配器的不同方式
 * <p>
 * <p>
 * <p>
 * 在Fi112Test.main中，你可以看到各种不同类型的适配器在运行。
 * 首先，Collection类型是AddableCollectionAdapter适配的。
 * <p>
 * 这个第二个版本使用了一个泛化的辅助方法，你可以看到这个泛化方法是如何捕获类型并因此而不必显式
 * 地写出来的一这是产生更优雅的代码的一种惯用技巧。
 * <p>
 * 接下来，使用了预适配的AddableSimpleQueue
 * 注意，在两种情况下，适配器都允许前面没有实现Addable的类用于Fill2.fill()中。
 * 使用像这样的适配器看起来是对缺乏潜在类型机制的一种补偿，因此允许编
 * 写出真正的泛化代码。
 * <p>
 * 但是，这是一个额外的步骤，并且是类库的创建者和消费者都必须理解的事物，
 * 而缺乏经验的程序员可能还没有能够掌握这个概念。
 * 潜在类型机制通过移除这个额外的步骤，使得泛化代码更容易应用，这就是它的价值所在。
 * <p>
 * 重点关注
 */
class Fill2Test {
    public static void main(String[] args) {
        // Adapt a Collection:
        List<Coffee> carrier = new ArrayList<>();
        Fill2.fill(
                new AddableCollectionAdapter<>(carrier),
                Coffee.class, 3
        );

        // Helper method captures the type:
        Fill2.fill(
                Adapter.collectionAdapter(carrier),
                Latte.class, 2
        );
        for (Coffee c : carrier) {
            print(c);
        }

        print("----------------------");

        // Use an adapted class:
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class, 4);
        Fill2.fill(coffeeQueue, Latte.class, 1);
        for (Coffee c : coffeeQueue) {
            print(c);
        }

    }
}
