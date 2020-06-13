package generics.test;

public abstract class Singleton<T> {
    private T t;

    public T getInstance() {
        if (t == null) {
            t = create();
        }
        return t;
    }

    protected abstract T create();
}
