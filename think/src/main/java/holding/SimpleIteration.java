package holding;

import java.util.Iterator;
import java.util.List;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class SimpleIteration {

    /**
     * 任何容器类，都必须有某种方式可以插入元素并将它们再次取回。
     * 毕竟，持有事物是容器最基本的工作。
     * <p>
     * 对于List,add()是插入元素的方法之一, 而get()是取出元素的方法之一
     * 如果从更高层的角度思考，会发现这里有个缺点：要使用容器，必须对容器的确切类型编程。
     * <p>
     * 初看起来这没什么不好，但是考虑下面的情况：
     * 如果原本是对着List编码的，但是后来发现如果能够把相同的代码应用于Set，
     * <p>
     * 将会显得非常方便，此时应该怎么做？
     * <p>
     * 或者打算从头开始编写通用的代码，它们只是使用容器，
     * 不知道或者说不关心容器的类型，
     * 那么如何才能不重写代码就可以应用于不同类型的容器？
     * <p>
     * 迭代器（也是一种设计模式）的概念可以用于达成此目的。
     * <p>
     * 迭代器是一个对象，它的工作是遍历并选择序列中的对象，而客户端程序员不必知道或关心该序
     * 列底层的结构。
     * <p>
     * 此外，迭代器通常被称为轻量级对象：创建它的代价小。
     * <p>
     * 因此，经常可以见到对迭代器有些奇怪的限制；
     * <p>
     * 例如，Java的Iterator只能单向移动，这个Iterator只能用来：
     * 1）使用方法iterator()要求容器返回一个Iterator。
     * Iterator将准备好返回序列的第一个元素。
     * 2）使用next())获得序列中的下一个元素。
     * 3）使用hasNext()检查序列中是否还有元素。
     * 4）使用remove()将迭代器新近返回的元素删除。
     * <p>
     * <p>
     * 有了Iterator就不必为容器中元素的数量操心了，那是由hasNext()和next()关心的事情。
     * <p>
     * 如果你只是向前遍历List，并不打算修改List对象本身，那么你可以看到foreach语法会显得更加简洁。
     * <p>
     * Iterator还可以移除由next()产生的最后一个元素，
     * 这意味着在调用remove()之前必须先调用next()
     * <p>
     * 接受对象容器并传递它，从而在每个对象上都执行操作，这种思想十分强大，并且贯穿于本书。
     * <p>
     * <p>
     * 重点关注.
     */
    public static void main(String[] args) {

        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();

        // A simpler approach, when possible:
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");
        }

        System.out.println();

        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }

        System.out.println(pets);
    }
}
