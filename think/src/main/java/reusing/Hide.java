package reusing;

import static net.mindview.util.Print.print;

// Overloading a base-class method name in a derived
// class does not hide the base-class versions.
class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class MilHouse {
}

class Bart extends Homer {

    void doh(MilHouse m) {
        print("doh(MilHouse)");
    }
}

/**
 * 7.4.2 名称屏蔽
 * <p>
 * 如果Java的基类拥有某个已被多次重载的方法名称，
 * <p>
 * 那么在导出类中重新定义该方法名称并不会屏蔽其在基类中的任何版本（这一点与C++不同）。
 * <p>
 * 因此，无论是在该层或者它的基类中对方法进行定义，重载机制都可以正常工作：
 * <p>
 * https://www.runoob.com/java/java-override-overload.html
 */
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new MilHouse());
    }
}