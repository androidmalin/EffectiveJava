package generics;

import java.util.Date;

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    public long getStamp() {
        return timeStamp.getStamp();
    }

    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

/**
 * 术语混型随时间的推移好像拥有了无数的含义，但是其最基本的概念是混合多个类的能力，以产生一个可以表示混型中所有类型的类。
 * 这往往是你最后的手段，它将使组装多个类变得简单易行。
 * <p>
 * 混型的价值之一是它们可以将特性和行为一致地应用于多个类之上。
 * 如果想在混型类中修改某些东西，作为一种意外的好处，这些修改将会应用于混型所应用的所有类型之上。
 * 正由于此， 混型有一点面向切面编程(AOP) 的味道，
 * 而切面经常被建议用来解决混型问题。
 * <p>
 * Mixin类基本上是在使用代理，因此每个混入类型都要求在Mixin中有一个相应的域，
 * 而你必须在Mixin中编写所有必需的方法，将方法调用转发给恰当的对
 * 象。
 * 这个示例使用了非常简单的类，但是当使用更复杂的混型时，代码数量会急速增加
 * http://ocrmaker.com/
 * 重点关注
 */
public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber());
    }
}
