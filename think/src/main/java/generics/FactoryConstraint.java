package generics;

interface FactoryI<T> {
    T create();
}

interface FactoryII<T> {
    T create();
}

class Foo2<T> {
    T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return 0;
    }
}

class Foo3<T> {
    T t;

    public <F extends FactoryII<T>> Foo3(F f) {
        t = f.create();
    }
}

class Food {
    public static class Factory implements FactoryII<Food> {
        @Override
        public Food create() {
            return new Food();
        }
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

/**
 * 重点关注
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        Foo2<Integer> integerFoo2 = new Foo2<>(new IntegerFactory());
        Foo2<Widget> widgetFoo2 = new Foo2<>(new Widget.Factory());
        Foo3<Food> foodFoo3 = new Foo3<>(new Food.Factory());
        Food t = foodFoo3.t;
    }
}
