package polymorphism.music3;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

@SuppressWarnings("unused")
class Instrument {

    void play(Note n) {
        print("Instrument.play() " + n);
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        print("Adjusting Instrument");
    }

    void aaa() {
    }
}

class Wind extends Instrument {

    @Override
    void play(Note n) {
        print("Wind.play() " + n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument {

    @Override
    void play(Note n) {
        print("Percussion.play() " + n);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        print("Adjusting Percussion");
    }
}

class Stringed extends Instrument {

    @Override
    void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    String what() {
        return "Stringed";
    }

    @Override
    void adjust() {
        print("Adjusting Stringed");
    }
}

class Brass extends Wind {

    @Override
    void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    void adjust() {
        print("Adjusting Brass");
    }
}

class Woodwind extends Wind {

    @Override
    void play(Note n) {
        print("Woodwind.play() " + n);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}

public class Music3 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    /**
     * 现在，让我们返回到"乐器"(Instrument)示例。由于有多态机制，我们可
     * 根据自己的需求对系统添加任意多的新类型，而不需更改tune()方法。
     * <p>
     * 在一个设计良好的OOP程序中，大多数或者所有方法都会遵循tune()的模型，而且只
     * 与基类接囗通信。
     * <p>
     * 这样的程序是可扩展的，因为可以从通用的基类继承出新的数
     * 据类型，从而新添一些功能。那些操纵基类接囗的方法不需要任何改动就可以应
     * 用于新类。
     * <p>
     * 考虑一下：对于"乐器"的例子，如果我们向基类中添加更多的方法，并加入
     * 一些新类，将会出现什么情况呢？请看下图：
     * <p>
     * <p>
     * 新添加的方法what()返回一个带有类描述的String引用；另一个新添加的
     * 方法adjust()则提供每种乐器的调音方法。
     * <p>
     * 在main0中，当我们将某种引用置入orchestra数组中，就会自动向上转型Instrument
     * <p>
     * 可以看到，tune()方法完全可以忽略它周围代码所发生的全部变化，依旧
     * 正常运行。
     * <p>
     * 这正是我们期望多态所具有的特性。我们所做的代码修改，不会对程
     * 序中其他不应受到影响的部分产生破坏。
     * <p>
     * 换句话说，多态是一项让程序员"将改变的事物与未变的事物分离开来"的重要技术。
     * <p>
     * 重点关注
     */
    public static void main(String[] args) {
        // UpCasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
