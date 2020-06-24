package polymorphism;

import static net.mindview.util.Print.print;

// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).
// 动态更改对象的行为通过组合（"状态"设计模式）。

//Actor:演员
class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    @Override
    public void act() {
        print("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        print("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}


/**
 * 学习了多态之后，看起来似乎所有东西都可以被继承，因为多态是一种如此巧妙的工具。
 * <p>
 * 事实上，当我们使用现成的类来建立新类时，如果首先考虑使用继承技术，
 * 反倒会加重我们的设计负担，使事情变得不必要地复杂起来。
 * <p>
 * <p>
 * 更好的方式是首先选择"组合"，尤其是不能十分确定应该使用哪一种方式时。
 * <p>
 * 组合不会强制我们的程序设计进入继承的层次结构中。
 * 而且，组合更加灵活，因为它可以动态选择类型（因此也就选择了行为）；
 * <p>
 * 相反，继承在编译时就需要知道确切类型。下面举例说明这一点：
 * <p>
 * <p>
 * 在这里，stage对象包含一个对Actor的引用，而Actor被初始化为HappyActor对象。
 * <p>
 * 这意味着performPlay()会产生某种特殊行为。
 * <p>
 * 既然引用在运行时可以与另一个不同的对象重新绑定起来，所以SadActor对象的引用可以在
 * actor中被替代，然后由performPlay()产生的行为也随之改变。
 * <p>
 * 这样一来，我们在运行期间获得了动态灵活性（这也称作状态模式）。
 * <p>
 * 与此相反，我们不能在运行期间决定继承不同的对象，因为它要求在编译期间完全确定下来。
 * <p>
 * 一条通用的准则是："用继承表达行为间的差异，并用字段表达状态上的变化"。
 * <p>
 * 在上述例子中，两者都用到了：通过继承得到了两个不同的类，用于表达act()方法的差异；
 * <p>
 * 而stage通过运用组合使自己的状态发生变化。
 * 在这种情况下，这种状态的改变也就产生了行为的改变。
 */
public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();

        stage.change();
        stage.performPlay();
    }
}
