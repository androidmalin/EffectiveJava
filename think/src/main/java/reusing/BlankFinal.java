package reusing;


class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

// "Blank" final fields.
public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p; // Blank final reference

    // Blank finals MUST be initialized in the constructor:
    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }


    /**
     * 空白final
     * <p>
     * Java允许生成“空白final，所谓空白final是指被声明为final又未给定初值的域。
     * <p>
     * 无论什么情况，编译器都确保空白final在使用前必须被初始化。
     * <p>
     * 但是，空白final在关键字final的使用上提供了更大的灵活性，
     * <p>
     * 为此，一个类中的final域就可以做到根据对象而有所不同，却又保持其恒定不变的特性。
     * <p>
     * 下面即为一例：
     * <p>
     * <p>
     * 必须在域的定义处或者每个构造器中用表达式对final进行赋值，
     * <p>
     * 这正是final域在使用前总是被初始化的原因所在。
     */
    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}