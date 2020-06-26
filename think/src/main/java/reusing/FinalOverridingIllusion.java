package reusing;


import static net.mindview.util.Print.print;

// It only looks like you can override
// a private or private final method.
class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        print("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.g()");
    }
}


/**
 * 7.8.2 final方法
 * 使用final方法的原因有两个。
 * <p>
 * 第一个原因是把方法锁定，以防任何继承类修改它的含义。
 * <p>
 * 这是出于设计的考虑：想要确保在继承中使方法行为保持不变，并且不会被覆盖。
 * <p>
 * 过去建议使用final方法的第二个原因是效率。
 * <p>
 * 在Java的早期实现中，如果将一个方法指明为final，就是同意编译器将针对该方法的所有调用都转为内嵌调用。
 * <p>
 * 当编译器发现一个final方法调用命令时，它会根据自己的谨慎判断，跳过插
 * 入程序代码这种正常方式而执行方法调用机制
 * （将参数压入栈，跳至方法代码处并执行，然后跳回并清理栈中的参数，处理返回值），
 * <p>
 * 并且以方法体中的实际代码的副本来替代方法调用。
 * <p>
 * 这将消除方法调用的开销。当然，如果一个方法很大，你的程序代码就会膨胀，
 * <p>
 * 因而可能看不到内嵌带来的任何性能提高，
 * <p>
 * 因为，所带来的性能提高会因为花费于方法内的时间量而被缩减。
 * <p>
 * <p>
 * 在最近的Java版本中，虚拟机（特别是hotspot技术）可以探测到这些情况，
 * 并优化去掉这些效率反而降低的额外的内嵌调用，因此不再需要使用final方法来进行优化了。
 * <p>
 * 事实上，这种做法正在逐渐地受到劝阻。
 * <p>
 * 在使用JavaSE5/6时，应该让编译器和JVM去处理效率问题，只有在想要明确禁止覆盖时，才将方法设置为final的
 * <p>
 * 类中所有的private方法都隐式地指定为final的。
 * <p>
 * 由于无法取用private方法，所以也就无法覆盖它。
 * <p>
 * 可以对private方法添加final修饰词，但这并不能给该方法增加任何额外的意义。
 * <p>
 * 这一问题会造成混淆。
 * <p>
 * 因为，如果你试图覆盖一个private方法（隐含是final的），似乎是奏效的，而且编译器也不会给出错误信息：
 * <p>
 * <p>
 * "覆盖"只有在某方法是基类的接囗的一部分时才会出现。
 * <p>
 * 即，必须能将一个对象向上转型为它的基本类型并调用相同的方法（这一点在下一章阐明）。
 * <p>
 * 如果某方法为private,它就不是基类的接囗的一部分。
 * <p>
 * 它仅是一些隐藏于类中的程序代码，只不过是具有相同的名称而已。
 * <p>
 * 但如果在导出类中以相同的名称生成一个
 * public、protected或包访问权限方法的话，该方法就不会产生在基类中出现的"仅
 * 具有相同名称"的情况。此时你并没有覆盖该方法，仅是生成了一个新的方法。
 * <p>
 * 由于private方法无法触及而且能有效隐藏，所以除了把它看成是因为它所归属的类
 * 的组织结构的原因而存在外，其他任何事物都不需要考虑到它。
 */
public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upCast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
}
