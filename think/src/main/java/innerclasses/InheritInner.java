package innerclasses;


class WithInner {
    class Inner {
    }
}


/**
 * 因为内部类的构造器必须连接到指向其外围类对象的引用，
 * 所以在继承内部类的时候，事情会变得有点复杂。
 * <p>
 * 问题在于，那个指向外围类对象的"秘密的"引用必须被初始化，
 * <p>
 * 而在导出类中不再存在可连接的默认对象。
 * <p>
 * 要解决这个问题，必须使用特殊的语法来明确说清它们之间的关联：
 */
// Inheriting an inner class.
public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // Won't compile
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
