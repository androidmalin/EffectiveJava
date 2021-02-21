package com.example.proto.deep;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式（PrototypePattern）指原型实例指定创建对象的种类，并且通过
 * 复制这些原型创建新的对象，属于创建型设计模式。
 * <p>
 * 原型模式的核心在于复制原型对象。以系统中已存在的一个对象为原型，直
 * 接基于内存二进制流进行复制，不需要再经历耗时的对象初始化过程（不调用构
 * 造函数），性能提升许多。当对象的构建过程比较耗时时，可以把当前系统中已
 * 存在的对象作为原型，对其进行复制（一般是基于二进制流的复制），躲避初始
 * 化过程，使得新对象的创建时间大大缩短。
 * <p>
 * <p>
 * 原型模式的优点
 * （1）Java自带的原型模式基于内存二进制流的复制，在性能上比直接new一个对象更加优良。
 * （2）可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，
 * 并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用
 * （例如恢复到历史某一状态），可辅助实现撤销操作。
 * <p>
 * 原型模式的缺点
 * （1）需要为每一个类都配置一个clone方法。
 * （2）clone方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 * （3）当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重
 * 嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起
 * 来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 */
public class Client {
    private static final boolean DEEP_COPY = false;

    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        ConcretePrototype cloneType;
        if (DEEP_COPY) {
            cloneType = prototype.deepClone();
        } else {
            cloneType = prototype.clone();
        }
        cloneType.getHobbies().add("技术控");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println("prototype == cloneType:" + (prototype == cloneType));

        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println("prototype.getHobbies() == cloneType.getHobbies():" + (prototype.getHobbies() == cloneType.getHobbies()));
    }
}
