package polymorphism;


import static net.mindview.util.Print.print;


/**
 * Cleaning up shared member objects.
 * <p>
 * static long counter跟踪所创建的Shared的实例的数量，还可以为id提供数值。
 * <p>
 * counter的类型是long而不是int,这样可以防止溢出
 * （这只是一个良好实践，对于本书中的所有示例，这种计数器不可能发生溢出）。
 * <p>
 * id是final的，因为我们不希望它的值在对象生命周期中被改变。
 * 在将一个共享对象附着到类上时，必须记住调用addRef()，
 * <p>
 * 但是dispose()方法将跟踪引用数，并决定何时执行清理。
 * <p>
 * 使用这种技巧需要加倍地细心，但是如果你正在共享需要清理的对象，那么你就没有太多的选择余地了。
 */
class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        print("Creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0) {
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        print("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}


public class ReferenceCounting {
    public static void main(String[] args) {

        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };

        for (Composing c : composing) {
            c.dispose();
        }
    }
}